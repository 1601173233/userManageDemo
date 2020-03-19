package com.userManager.menu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.base.common.service.impl.BaseServiceImpl;
import com.base.common.util.CommonModelUtils;
import com.base.common.util.ExceptionUtil;
import com.base.common.util.TreeUtil;
import com.base.common.vo.TreeVo;
import com.userManager.dict.entity.Dict;
import com.userManager.dict.entity.DictType;
import com.userManager.menu.entity.Menu;
import com.userManager.menu.mapper.MenuMapper;
import com.userManager.menu.service.MenuService;
import com.userManager.user.entity.District;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单服务接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@Service
public class MenuServiceImpl
        extends BaseServiceImpl<MenuMapper, Menu> implements MenuService {


    @Override
    public Menu getByCode(String code){
        Menu menu = new Menu();
        menu.setCode(code);
        return getOne(new QueryWrapper<>(menu));
    }

    @Override
    public boolean save(Menu menu){
        if(StringUtils.isEmpty(menu.getParentCode())){
            ExceptionUtil.validError("父节点编码不能为空");
        }

        String code = getNextCode(menu.getParentCode());
        menu.setCode(code);
        menu.setSortNum(getNextSortNum(menu.getParentCode()));
        return super.save(menu);
    }

    @Override
    public boolean move(Integer id, Integer newParentId, Integer nextNodeId){
        Menu menu, nextMenu;
        boolean isChangeParent = false; // 是否修改了父节点

        menu = getById(id);

        // 获取父节点编码
        String parentCode;
        // 如果父节点是根节点的话
        if(newParentId == null || newParentId == 0){
            parentCode = "0";
        }else{
            Menu parentMenu = getById(newParentId);
            parentCode = parentMenu.getCode();
        }

        // 如果父节点发生了改变的话
        if(!parentCode.equals(menu.getParentCode())){
            String oldCode = menu.getCode();

            // 当前节点以及所有子孙节点的编码都需要发生改变
            menu.setCode(getNextCode(parentCode));

            // 更新所有的子节点
            baseMapper.updateSonCode(oldCode, menu.getCode());

            menu.setParentCode(parentCode);

            // 标示为修改了父节点
            isChangeParent = true;
        }

        // 如果当前节点是最后一个节点
        if(nextNodeId == null){
            menu.setSortNum(getNextSortNum(menu.getParentCode()));
        }else{
            // 获取后一个节点原来的排序号
            nextMenu = getById(nextNodeId);
            Integer nextDistrictSortNum = nextMenu.getSortNum();
            Integer oldSortNum = menu.getSortNum(); // 被移动节点的原有排序号

            // 如果修改了父节点，那么原有排序号为当前父节点的新的排序号
            if(isChangeParent){
                oldSortNum = getNextSortNum(parentCode);
            }

            // 如果是向前移动
            if(oldSortNum > nextDistrictSortNum){
                // 新节点位置到原来节点位置中间的所有节点的所有排序号都 + 1
                baseMapper.updateOtherNodeSort(parentCode, nextDistrictSortNum, oldSortNum - 1, 1);

                // 当前节点的排序号等于后一个节点排序号
                menu.setSortNum(nextDistrictSortNum);
            }else{
                // 新节点位置到原来节点位置中间的所有节点的所有排序号都 - 1
                baseMapper.updateOtherNodeSort(parentCode, oldSortNum, nextDistrictSortNum - 1, -1);

                // 当前节点的排序号等于后一个节点排序号 - 1
                menu.setSortNum(nextDistrictSortNum - 1);
            }

        }
        return updateById(menu);
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
    public TreeVo<Menu> getTree() {
        List<Menu> menuList = select(null);
        List<TreeVo<Menu>> menuTreeVoList = new ArrayList<>(menuList.size());
        for(Menu mMenu : menuList){
            menuTreeVoList.add(mMenu.convertTreeNode());
        }

        TreeVo<Menu> parentTreeVo = new TreeVo();
        parentTreeVo.setParentId(null);
        parentTreeVo.setName("菜单");
        parentTreeVo.setId("0");
        parentTreeVo.setData(null);

        // 构造为树结构
        menuTreeVoList = TreeUtil.bulidTree(menuTreeVoList, "0");
        parentTreeVo.setChildrens(menuTreeVoList);
        return parentTreeVo;
    }

}