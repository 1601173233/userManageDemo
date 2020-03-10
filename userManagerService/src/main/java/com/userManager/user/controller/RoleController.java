package com.userManager.user.controller;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.userManager.user.entity.Role;
import com.userManager.user.service.RoleService;
import com.userManager.user.api.RoleApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * 角色表服务控制层
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@RestController
@Slf4j
public class RoleController implements RoleApi {
    /**
     * 角色管理服务
     */
    @Autowired
    RoleService roleService;

    @Override
    public Role getById(String id){
        log.info("根据 id 获取角色信息");

        Role result = roleService.getById(id);

        // 根据id获取记录
        return result;
    }

    @Override
    public boolean removeById(String id){
        log.info("根据 id 删除角色信息");

        // 删除对应的记录
        boolean result = roleService.removeById(id);

        return result;
    }

    @Override
    public boolean save(Role role){
        log.info("新增角色信息");

        // 新增一条记录
        boolean result = roleService.save(role);

        return result;
    }

    @Override
    public boolean updateById(Role role){
        log.info("更新角色信息");

        // 新增一条记录
        boolean result = roleService.updateById(role);

        return result;
    }

    @Override
    public Role selectOne(Role role){
        log.info("根据信息获取角色信息单个对象");

        // 根据信息获取角色信息列表
        Role entity = roleService.selectOne(role);

        return entity;
    }

    @Override
    public List<Role> select(Role role){
        log.info("根据信息获取角色信息列表");

        // 根据信息获取角色信息列表
        List<Role> list = roleService.select(role);

        return list;
    }

    @Override
    public PageResultVo<Role> getPage(Role role, PageParamsVo pageParamsVo){
        log.info("根据信息获取角色分页信息");

        // 根据信息获取角色分页信息
        PageResultVo<Role> page = roleService.getPage(role, pageParamsVo);

        return page;
    }
}
