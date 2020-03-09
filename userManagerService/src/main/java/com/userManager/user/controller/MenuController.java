package com.userManager.user.controller;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.userManager.user.entity.Menu;
import com.userManager.user.service.MenuService;
import com.userManager.user.api.MenuApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * 菜单表服务控制层
 *
 * @author : huangyujie
 * @version : 2020年03月09日
 * @since
 */
@RestController
@Slf4j
public class MenuController implements MenuApi {
    /**
     * 菜单管理服务
     */
    @Autowired
    MenuService menuApi;

    @Override
    public Menu getById(String id){
        log.info("根据 id 获取菜单信息");

        Menu result = menuApi.getById(id);

        // 根据id获取记录
        return result;
    }

    @Override
    public boolean removeById(String id){
        log.info("根据 id 删除菜单信息");

        // 删除对应的记录
        boolean result = menuApi.removeById(id);

        return result;
    }

    @Override
    public boolean save(Menu menu){
        log.info("新增菜单信息");

        // 新增一条记录
        boolean result = menuApi.save(menu);

        return result;
    }

    @Override
    public boolean updateById(Menu menu){
        log.info("更新菜单信息");

        // 新增一条记录
        boolean result = menuApi.updateById(menu);

        return result;
    }

    @Override
    public Menu selectOne(Menu menu){
        log.info("根据信息获取菜单信息单个对象");

        // 根据信息获取菜单信息列表
        Menu entity = menuApi.selectOne(menu);

        return entity;
    }

    @Override
    public List<Menu> select(Menu menu){
        log.info("根据信息获取菜单信息列表");

        // 根据信息获取菜单信息列表
        List<Menu> list = menuApi.select(menu);

        return list;
    }

    @Override
    public PageResultVo<Menu> getPage(Menu menu, PageParamsVo pageParamsVo){
        log.info("根据信息获取菜单分页信息");

        // 根据信息获取菜单分页信息
        PageResultVo<Menu> page = menuApi.getPage(menu, pageParamsVo);

        return page;
    }
}
