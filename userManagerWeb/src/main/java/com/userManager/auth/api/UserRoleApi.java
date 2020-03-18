package com.userManager.auth.api;

import com.userManager.auth.entity.UserRole;
import com.userManager.user.entity.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * 用户的角色对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@FeignClient(name = "${serviceName.gateway}/${serviceName.userManage}")
public interface UserRoleApi{
    /**
     * 根据用户ID获取用户对应的角色列表
     */
    @RequestLine(value = "GET /innerApi/auth/userRoleApi/selectByUserId")
    List<UserRole> selectByUserId(@Param("userId") Integer userId);

    /**
     * 根据角色ID获取用户列表
     */
    @RequestLine(value = "GET /innerApi/auth/userRoleApi/selectUserByRoleId")
    List<User> selectUserByRoleId(@Param("roleId") Integer roleId);

    /**
     * 给某个用户设置角色
     */
    @RequestLine(value = "POST /innerApi/auth/userRoleApi/setRole")
    Boolean setRole(@Param(value = "userId") Integer userId,
                    @Param(value = "roleIdList") List<Integer> roleIdList);
}