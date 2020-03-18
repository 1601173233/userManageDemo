package com.userManager.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.base.common.service.impl.BaseServiceImpl;
import com.base.common.util.CommonModelUtils;
import com.base.common.util.ExceptionUtil;
import com.userManager.user.entity.Dept;
import com.userManager.user.entity.District;
import com.userManager.user.enums.DeptNodeType;
import com.userManager.user.mapper.DeptMapper;
import com.userManager.user.service.DeptService;
import com.userManager.user.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 部门服务接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@Service
public class DeptServiceImpl
        extends BaseServiceImpl<Dept, DeptMapper> implements DeptService {
    @Autowired
    private DistrictService districtService;


    @Override
    public Dept getByCode(String code){
        Dept dept = new Dept();
        dept.setCode(code);
        return getOne(new QueryWrapper<>(dept));
    }

    @Override
    public boolean save(Dept dept){
        String parentCode = "";
        String districtCode = "";

        if(dept.getParentType() == null){
            ExceptionUtil.validError("父节点类型不能为空");
        }else if(dept.getParentType().equals(DeptNodeType.DISTRICT.getCode())){
            // 如果父节点是行政区,默认父部门编码为0
            districtCode = dept.getParentCode();
            parentCode = "0";
        }else if(dept.getParentType().equals(DeptNodeType.DEPT.getCode())){
            // 如果父节点是部门，那么行政区跟父部门的行政区一致
            parentCode = dept.getParentCode();

            Dept parentDept = getByCode(parentCode);
            districtCode = parentDept.getDistrictCode();
        }else{
            ExceptionUtil.validError("父节点类型不存在，请重新确认！");
        }

        String code = getNextCode(parentCode);
        dept.setCode(code);
        dept.setSortNum(getNextSortNum(parentCode));
        dept.setParentCode(parentCode);
        dept.setDistrictCode(districtCode);
        return super.save(dept);
    }

    /**
     * 根据父节点编码获取下一个节点的编码
     * @param parentCode
     * @return
     */
    public String getNextCode(String parentCode){
        String maxCode = baseMapper.getMaxCodeByParentCode(parentCode);
        return CommonModelUtils.getNextCode(parentCode, maxCode);
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
    public boolean move(Integer id, Integer newParentId, Integer parentType, Integer nextNodeId) {
        Dept dept, nextDept;
        boolean isChangeParent = false; // 是否修改了父节点
        String districtCode = "", parentCode = "";

        dept = getById(id);

        // 判断当前的父节点类型，获取对应的父节点编码和行政区编码
        if(parentType == null){
            ExceptionUtil.validError("父节点类型不能为空");
        }else if(parentType.equals(DeptNodeType.DISTRICT.getCode())){
            // 如果父节点是行政区,默认父部门编码为0
            // 如果是行政区的根节点,行政区编码为0
            if(newParentId.equals(0)) {
                districtCode = "0";
            }else{
                District district = districtService.getById(newParentId);
                districtCode = district.getCode();
            }

            parentCode = "0";
        }else if(parentType.equals(DeptNodeType.DEPT.getCode())){
            // 如果父节点是部门，那么行政区跟父部门的行政区一致
            Dept parentDept = getById(newParentId);

            parentCode = parentDept.getCode();
            districtCode = parentDept.getDistrictCode();
        }else{
            ExceptionUtil.validError("父节点类型不存在，请重新确认！");
        }

        // 如果父节点类型发生了改变
        if(!dept.getParentType().equals(parentType)
                || !dept.getDistrictCode().equals(districtCode)
                || !dept.getParentCode().equals(parentCode)){
            isChangeParent = true;
        }

        // 如果修改行政区的话，更新所有子行政区的编码
        if(!dept.getDistrictCode().equals(districtCode)){
            baseMapper.updateSonDistrictCode(dept.getCode(), districtCode);
        }

        // 如果父节点发生了改变的话
        if(isChangeParent){
            String oldCode = dept.getCode();

            // 当前节点以及所有子孙节点的编码都需要发生改变
            dept.setCode(getNextCode(parentCode));

            // 更新所有的子节点
            baseMapper.updateSonCode(oldCode, dept.getCode());

            dept.setParentCode(parentCode);
            dept.setParentType(parentType);
            dept.setDistrictCode(districtCode);

            // 标示为修改了父节点
            isChangeParent = true;
        }

        // 如果当前节点是最后一个节点
        if(nextNodeId == null){
            dept.setSortNum(getNextSortNum(dept.getParentCode()));
        }else{
            // 获取后一个节点原来的排序号
            nextDept = getById(nextNodeId);
            Integer nextDistrictSortNum = nextDept.getSortNum();
            Integer oldSortNum = dept.getSortNum(); // 被移动节点的原有排序号

            // 如果修改了父节点，那么原有排序号为当前父节点的新的排序号
            if(isChangeParent){
                oldSortNum = getNextSortNum(parentCode);
            }

            // 如果是向前移动
            if(oldSortNum > nextDistrictSortNum){
                // 新节点位置到原来节点位置中间的所有节点的所有排序号都 + 1
                baseMapper.updateOtherNodeSort(parentCode, nextDistrictSortNum, oldSortNum - 1, 1);

                // 当前节点的排序号等于后一个节点排序号
                dept.setSortNum(nextDistrictSortNum);
            }else{
                // 新节点位置到原来节点位置中间的所有节点的所有排序号都 - 1
                baseMapper.updateOtherNodeSort(parentCode, oldSortNum, nextDistrictSortNum - 1, -1);

                // 当前节点的排序号等于后一个节点排序号 - 1
                dept.setSortNum(nextDistrictSortNum - 1);
            }

        }
        return updateById(dept);
    }

    @Override
    public void updateDistrictCodeByDistrictMove(String oldCode, String code) {
        baseMapper.updateDistrictCodeByDistrictMove(oldCode, code);
    }
}