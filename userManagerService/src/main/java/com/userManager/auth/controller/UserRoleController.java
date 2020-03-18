package com.userManager.auth.controller;

import com.userManager.auth.api.UserRoleApi;
import com.userManager.auth.entity.UserRole;
import com.userManager.auth.service.UserRoleService;
import com.userManager.user.entity.User;
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

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public List<UserRole> selectByUserId(Integer userId) {
        return userRoleService.selectByUserId(userId);
    }

    @Override
    public List<User> selectUserByRoleId(Integer roleId) {
        return userRoleService.selectUserByRoleId(roleId);
    }

    @Override
    public Boolean setRole(Integer userId, List<Integer> roleIdList) {
        return userRoleService.setRole(userId, roleIdList);
    }
}
