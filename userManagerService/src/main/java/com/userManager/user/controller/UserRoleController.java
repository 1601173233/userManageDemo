package com.userManager.user.controller;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.userManager.user.entity.UserRole;
import com.userManager.user.service.UserRoleService;
import com.userManager.user.api.UserRoleApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * 用户的角色表服务控制层
 *
 * @author : huangyujie
 * @version : 2020年03月09日
 * @since
 */
@RestController
@Slf4j
public class UserRoleController implements UserRoleApi {
    /**
     * 用户的角色管理服务
     */
    @Autowired
    UserRoleService userRoleApi;

    @Override
    public UserRole getById(String id){
        log.info("根据 id 获取用户的角色信息");

        UserRole result = userRoleApi.getById(id);

        // 根据id获取记录
        return result;
    }

    @Override
    public boolean removeById(String id){
        log.info("根据 id 删除用户的角色信息");

        // 删除对应的记录
        boolean result = userRoleApi.removeById(id);

        return result;
    }

    @Override
    public boolean save(UserRole userRole){
        log.info("新增用户的角色信息");

        // 新增一条记录
        boolean result = userRoleApi.save(userRole);

        return result;
    }

    @Override
    public boolean updateById(UserRole userRole){
        log.info("更新用户的角色信息");

        // 新增一条记录
        boolean result = userRoleApi.updateById(userRole);

        return result;
    }

    @Override
    public UserRole selectOne(UserRole userRole){
        log.info("根据信息获取用户的角色信息单个对象");

        // 根据信息获取用户的角色信息列表
        UserRole entity = userRoleApi.selectOne(userRole);

        return entity;
    }

    @Override
    public List<UserRole> select(UserRole userRole){
        log.info("根据信息获取用户的角色信息列表");

        // 根据信息获取用户的角色信息列表
        List<UserRole> list = userRoleApi.select(userRole);

        return list;
    }

    @Override
    public PageResultVo<UserRole> getPage(UserRole userRole, PageParamsVo pageParamsVo){
        log.info("根据信息获取用户的角色分页信息");

        // 根据信息获取用户的角色分页信息
        PageResultVo<UserRole> page = userRoleApi.getPage(userRole, pageParamsVo);

        return page;
    }
}
