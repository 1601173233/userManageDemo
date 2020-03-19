package com.userManager.menu.api;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.base.common.vo.TreeVo;
import com.userManager.dict.entity.Dict;
import com.userManager.menu.entity.Menu;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

/**
 * 菜单对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@FeignClient(name = "${serviceName.gateway}/${serviceName.userManage}")
public interface MenuApi{
    /**
     * 根据 id 获取菜单信息
     * @param id
     * @return
     */
    @RequestLine(value = "GET /innerApi/menu/menuApi/getById")
    Menu getById(@Param("id") String id);

    /**
     * 根据 id 删除菜单信息
     * @param id
     * @return
     */
    @RequestLine(value = "DELETE /innerApi/menu/menuApi/removeById")
    boolean removeById(@Param("id") String id);

    /**
     * 新增菜单信息
     * @param menu 菜单信息
     * @return
     */
    @RequestLine(value = "PUT /innerApi/menu/menuApi/save")
    boolean save(@Param("menu") Menu menu);

    /**
     * 更新菜单信息
     * @param menu 菜单信息
     * @return
     */
    @RequestLine(value = "POST /innerApi/menu/menuApi/updateById")
    boolean updateById(@Param("menu") Menu menu);

    /**
     * 根据信息获取菜单信息单个对象
     * @param menu 菜单信息
     * @return
     */
    @RequestLine(value = "GET /innerApi/menu/menuApi/selectOne")
    Menu selectOne(@Param("menu") Menu menu);

    /**
     * 根据信息获取菜单信息列表
     * @param menu 菜单信息
     * @return
     */
    @RequestLine(value = "GET /innerApi/menu/menuApi/select")
    List<Menu> select(@Param("menu") Menu menu);

    /**
     * 根据信息获取菜单分页信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @RequestLine(value = "GET /innerApi/menu/menuApi/getPage")
    PageResultVo<Menu> getPage(@Param("menu") Menu menu, @Param("pageParamsVo") PageParamsVo pageParamsVo);

    /**
     * 节点移动到指定的父节点
     * @param id 移动的节点ID
     * @param newParentId 父节点ID
     * @param nextNodeId 移动后当前节点后一个节点的ID，空表示当前节点为最后一个节点
     * @return
     */
    @RequestLine(value = "PUT /innerApi/menu/menuApi/move")
    boolean move(@Param("id") Integer id,
                 @Param("newParentId") Integer newParentId,
                 @Param("nextNodeId") Integer nextNodeId);

    /**
     * 根据获取菜单树
     * @return
     */
    @RequestLine(value = "GET /innerApi/menu/menuApi/getTree")
    TreeVo<Menu> getTree();
}