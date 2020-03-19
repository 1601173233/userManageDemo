package com.userManager.menu.service;

import com.base.common.service.BaseService;
import com.base.common.vo.TreeVo;
import com.userManager.menu.entity.Menu;
import com.userManager.user.entity.District;

/**
 * 菜单服务接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
public interface MenuService extends BaseService<Menu>{

    /**
     * 根据菜单编码获取数据
     * @param code
     * @return
     */
    Menu getByCode(String code);

    /**
     * 节点移动到指定的父节点
     * @param id 移动的节点ID
     * @param newParentId 父节点ID
     * @param nextNodeId 移动后当前节点后一个节点的ID，空表示当前节点为最后一个节点
     * @return
     */
    boolean move(Integer id, Integer newParentId, Integer nextNodeId);

    /**
     * 根据信息获取菜单树
     * @return
     */
    TreeVo<Menu> getTree();


}