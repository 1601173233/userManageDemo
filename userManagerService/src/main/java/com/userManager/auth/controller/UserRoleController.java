package com.userManagerauth.controller;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.userManagerauth.entity.UserRole;
import com.userManagerauth.service.UserRoleService;
import com.userManagerauth.api.UserRoleApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * 用户的角色表服务控制层
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@RestController
@Slf4j
public class UserRoleController implements UserRoleApi {
    /**
     * 用户的角色管理服务
     */
    @Autowired
    UserRoleService userRoleService;

    @Override
    public UserRole getById(String id){
        log.info("根据 id 获取用户的角色信息");

        UserRole result = userRoleService.getById(id);

        // 根据id获取记录
        return result;
    }

    @Override
    public boolean removeById(String id){
        log.info("根据 id 删除用户的角色信息");

        // 删除对应的记录
        boolean result = userRoleService.removeById(id);

        return result;
    }

    @Override
    public boolean save(UserRole userRole){
        log.info("新增用户的角色信息");

        // 新增一条记录
        boolean result = userRoleService.save(userRole);

        return result;
    }

    @Override
    public boolean updateById(UserRole userRole){
        log.info("更新用户的角色信息");

        // 新增一条记录
        boolean result = userRoleService.updateById(userRole);

        return result;
    }

    @Override
    public UserRole selectOne(UserRole userRole){
        log.info("根据信息获取用户的角色信息单个对象");

        // 根据信息获取用户的角色信息列表
        UserRole entity = userRoleService.selectOne(userRole);

        return entity;
    }

    @Override
    public List<UserRole> select(UserRole userRole){
        log.info("根据信息获取用户的角色信息列表");

        // 根据信息获取用户的角色信息列表
        List<UserRole> list = userRoleService.select(userRole);

        return list;
    }

    @Override
    public PageResultVo<UserRole> getPage(UserRole userRole, PageParamsVo pageParamsVo){
        log.info("根据信息获取用户的角色分页信息");

        // 根据信息获取用户的角色分页信息
        PageResultVo<UserRole> page = userRoleService.getPage(userRole, pageParamsVo);

        return page;
    }
}
