package com.userManager.menu.api;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.userManager.menu.entity.Menu;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 菜单对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
public interface MenuApi{
    /**
     * 根据 id 获取菜单信息
     * @param id
     * @return
     */
    @GetMapping(value = "/innerApi/menu/menuApi/getById")
    Menu getById(String id);

    /**
     * 根据 id 删除菜单信息
     * @param id
     * @return
     */
    @DeleteMapping(value = "/innerApi/menu/menuApi/removeById")
    boolean removeById(String id);

    /**
     * 新增菜单信息
     * @param menu 菜单信息
     * @return
     */
    @PutMapping(value = "/innerApi/menu/menuApi/save")
    boolean save(@RequestPart("menu") Menu menu);

    /**
     * 更新菜单信息
     * @param menu 菜单信息
     * @return
     */
    @PostMapping(value = "/innerApi/menu/menuApi/updateById")
    boolean updateById(@RequestPart("menu") Menu menu);

    /**
     * 根据信息获取菜单信息单个对象
     * @param menu 菜单信息
     * @return
     */
    @GetMapping(value = "/innerApi/menu/menuApi/selectOne")
    Menu selectOne(@RequestPart("menu") Menu menu);

    /**
     * 根据信息获取菜单信息列表
     * @param menu 菜单信息
     * @return
     */
    @GetMapping(value = "/innerApi/menu/menuApi/select")
    List<Menu> select(@RequestPart("menu") Menu menu);

    /**
     * 根据信息获取菜单分页信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @GetMapping(value = "/innerApi/menu/menuApi/getPage")
    PageResultVo<Menu> getPage(@RequestPart("menu") Menu menu,
                                            @RequestPart("pageParamsVo") PageParamsVo pageParamsVo);
}