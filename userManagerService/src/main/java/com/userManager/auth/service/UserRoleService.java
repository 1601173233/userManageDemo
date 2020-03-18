package com.userManager.auth.service;

import com.base.common.service.BaseService;
import com.userManager.auth.entity.UserRole;
import com.userManager.user.entity.User;

import java.util.List;

/**
 * 用户的角色服务接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
public interface UserRoleService extends BaseService<UserRole>{
    /**
     * 根据用户ID获取用户对应的角色列表
     */
    List<UserRole> selectByUserId(Integer userId);

    /**
     * 根据角色ID获取用户列表
     */
    List<User> selectUserByRoleId(Integer roleId);

    /**
     * 给某个用户设置角色
     */
    Boolean setRole(Integer userId, List<Integer> roleIdList);

}