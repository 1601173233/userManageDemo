package com.userManager.auth.api;

import com.userManager.auth.entity.UserRole;
import com.userManager.user.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;

import java.util.List;

/**
 * 用户的角色对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
public interface UserRoleApi{
    /**
     * 根据用户ID获取用户对应的角色列表
     */
    @GetMapping(value = "/innerApi/auth/userRoleApi/selectByUserId")
    List<UserRole> selectByUserId(Integer userId);

    /**
     * 根据角色ID获取用户列表
     */
    @GetMapping(value = "/innerApi/auth/userRoleApi/selectUserByRoleId")
    List<User> selectUserByRoleId(Integer roleId);

    /**
     * 给某个用户设置角色
     */
    @PostMapping(value = "/innerApi/auth/userRoleApi/setRole")
    Boolean setRole(@RequestPart(value = "userId") Integer userId,
                    @RequestPart(value = "roleIdList", required = false) List<Integer> roleIdList);
}