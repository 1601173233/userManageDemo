package com.userManager.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.base.common.service.impl.BaseServiceImpl;
import com.base.common.util.ExceptionUtil;
import com.base.common.util.TreeUtil;
import com.base.common.vo.TreeVo;
import com.userManager.user.entity.Dept;
import com.userManager.user.entity.District;
import com.userManager.user.enums.DeptParentType;
import com.userManager.user.mapper.DistrictMapper;
import com.userManager.user.service.DeptService;
import com.userManager.user.service.DistrictService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 区域管理服务接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@Service
public class DistrictServiceImpl
        extends BaseServiceImpl<District, DistrictMapper> implements DistrictService {
    @Autowired
    private DeptService deptService;

    @Override
    public District getByCode(String code){
        District district = new District();
        district.setCode(code);
        return getOne(new QueryWrapper<>(district));
    }

    @Override
    public boolean save(District district){
        if(StringUtils.isEmpty(district.getParentCode())){
            ExceptionUtil.validError("父节点编码不能为空");
        }

        String code = getNextCode(district.getParentCode());
        district.setCode(code);
        district.setSortNum(getNextSortNum(district.getParentCode()));
        return super.save(district);
    }

    @Override
    public boolean move(Integer id, Integer newParentId, Integer nextNodeId){
        District district, nextDistrict;
        boolean isChangeParent = false; // 是否修改了父节点

        district = getById(id);

        // 获取父节点编码
        String parentCode;
        // 如果父节点是根节点的话
        if(newParentId == null || newParentId == 0){
            parentCode = "0";
        }else{
            District parentDistrict = getById(newParentId);
            parentCode = parentDistrict.getCode();
        }

        // 如果父节点发生了改变的话
        if(!parentCode.equals(district.getParentCode())){
            String oldCode = district.getCode();

            // 当前节点以及所有子孙节点的编码都需要发生改变
            district.setCode(getNextCode(parentCode));

            // 更新所有的子节点
            baseMapper.updateSonCode(oldCode, district.getCode());

            // 修改所有关联的部门的行政区编码
            deptService.updateDistrictCodeByDistrictMove(oldCode, district.getCode());

            district.setParentCode(parentCode);

            // 标示为修改了父节点
            isChangeParent = true;
        }

        // 如果当前节点是最后一个节点
        if(nextNodeId == null){
            district.setSortNum(getNextSortNum(district.getParentCode()));
        }else{
            // 获取后一个节点原来的排序号
            nextDistrict = getById(nextNodeId);
            Integer nextDistrictSortNum = nextDistrict.getSortNum();
            Integer oldSortNum = district.getSortNum(); // 被移动节点的原有排序号

            // 如果修改了父节点，那么原有排序号为当前父节点的新的排序号
            if(isChangeParent){
                oldSortNum = getNextSortNum(parentCode);
            }

            // 如果是向前移动
            if(oldSortNum > nextDistrictSortNum){
                // 新节点位置到原来节点位置中间的所有节点的所有排序号都 + 1
                baseMapper.updateOtherNodeSort(parentCode, nextDistrictSortNum, oldSortNum - 1, 1);

                // 当前节点的排序号等于后一个节点排序号
                district.setSortNum(nextDistrictSortNum);
            }else{
                // 新节点位置到原来节点位置中间的所有节点的所有排序号都 - 1
                baseMapper.updateOtherNodeSort(parentCode, oldSortNum, nextDistrictSortNum - 1, -1);

                // 当前节点的排序号等于后一个节点排序号 - 1
                district.setSortNum(nextDistrictSortNum - 1);
            }

        }
        return updateById(district);
    }

    /**
     * 根据父节点编码获取下一个节点的编码
     * @param parentCode
     * @return
     */
    public String getNextCode(String parentCode){
        String maxCode = baseMapper.getMaxCodeByParentCode(parentCode);

        // 如果当前父节点不存在子节点
        if(maxCode == null){
            // 如果父节点是默认节点
            if(parentCode.equals("0")){
                maxCode = "01";
            }else{
                maxCode = parentCode + "01";
            }
        }else{
            // 否则节点序号 + 1
            Integer maxCodeNum = Integer.parseInt(maxCode.substring(maxCode.length() - 2, maxCode.length()));
            maxCodeNum = maxCodeNum + 1;
            maxCode = maxCodeNum >= 10 ? maxCodeNum.toString() : "0" + maxCodeNum;

            // 把父节点序号补充回去
            if(!parentCode.equals("0")){
                maxCode = parentCode + maxCode;
            }
        }

        return maxCode;
    }

    /**
     * 根据父节点编码获取下一个节点的编码
     * @param parentCode
     * @return
     */
    public Integer getNextSortNum(String parentCode){
        Integer maxSortNum = baseMapper.getMaxSortNumByParentCode(parentCode);
        if(maxSortNum == null){
            maxSortNum = 0;
        }

        return maxSortNum + 1;
    }

    @Override
    public TreeVo<String> getTree() {
        return getTreeByParentCode("0");
    }

    @Override
    public TreeVo<String> getTreeByParentCode(String parentCode) {
        if(parentCode == null){
            parentCode = "0";
        }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.likeRight("CODE", parentCode);

        List<District> districtList = list(queryWrapper);

        // 父节点
        TreeVo<String> parentTreeVo = null;

        // 如果是默认父节点
        if(parentCode.equals("0")) {
            parentTreeVo = new TreeVo();
            parentTreeVo.setParentId(null);
            parentTreeVo.setName("行政区");
            parentTreeVo.setId("0");
            parentTreeVo.setData("0");
        }

        // 把结果转换为树节点
        List<TreeVo<String>> treeVoList = new ArrayList<>(districtList.size());
        for(District district : districtList){
            TreeVo<String> treeVo = district.convertTreeNode();

            // 如果是父节点，记录起来
            if(treeVo.getId().equals(parentCode)){
                parentTreeVo = treeVo;
            }

            treeVoList.add(treeVo);
        }

        // 如果默认父节点为空，那么直接返回空数据
        if(parentTreeVo == null){
            return null;
        }

        // 树节点构造为树结构
        treeVoList = TreeUtil.bulidTree(treeVoList, parentCode.toString(), true);

        parentTreeVo.setChildrens(treeVoList);
        return parentTreeVo;
    }

    @Override
    public TreeVo<String> getTreeWithDept() {
        return getTreeWithDeptByParentCode("0");
    }

    @Override
    public TreeVo<String> getTreeWithDeptByParentCode(String parentCode) {
        if(parentCode == null){
            parentCode = "0";
        }

        // 行政区查询条件
        QueryWrapper districtQueryWrapper = new QueryWrapper();
        districtQueryWrapper.likeRight("CODE", parentCode);

        // 部门查询条件
        QueryWrapper deptQueryWrapper = new QueryWrapper();
        deptQueryWrapper.likeRight("DISTRICT_CODE", parentCode);

        List<District> districtList = list(districtQueryWrapper);
        List<Dept> deptList = deptService.list(deptQueryWrapper);

        // 父节点
        TreeVo<String> parentTreeVo = null;

        // 如果是默认父节点
        if(parentCode.equals("0")) {
            parentTreeVo = new TreeVo();
            parentTreeVo.setParentId(null);
            parentTreeVo.setName("");
            parentTreeVo.setId("0");
            parentTreeVo.setData("0");
        }

        // 把结果转换为树节点
        List<TreeVo<String>> treeVoList = new ArrayList<>(districtList.size());
        for(District district : districtList){
            TreeVo<String> treeVo = district.convertTreeNode();

            // 如果是父节点，记录起来
            if(treeVo.getId().equals(parentCode)){
                parentTreeVo = treeVo;
            }

            treeVoList.add(treeVo);
        }

        // 如果默认父节点为空，那么直接返回空数据
        if(parentTreeVo == null){
            return null;
        }

        for(Dept dept : deptList){
            dept.setSortNum(dept.getSortNum() + 10000); // 默认排在行政区之后
            treeVoList.add(dept.convertTreeNode());
        }

        // 树节点构造为树结构
        treeVoList = TreeUtil.bulidTree(treeVoList, parentCode, DeptParentType.DISTRICT.getCode().toString(),true);
        parentTreeVo.setChildrens(treeVoList);
        return parentTreeVo;
    }
}