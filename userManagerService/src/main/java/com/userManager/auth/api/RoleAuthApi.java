package com.userManager.auth.api;

import com.userManager.auth.entity.RoleAuth;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;

import java.util.List;

/**
 * 角色授权表对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
public interface RoleAuthApi{
    /**
     * 根据角色ID获取角色拥有的权限列表
     */
    @GetMapping(value = "/innerApi/auth/roleAuthApi/selectByRoleId")
    List<RoleAuth> selectByRoleId(Integer roleId);

    /**
     * 给某个角色设置权限
     */
    @PostMapping(value = "/innerApi/auth/roleAuthApi/setAuth")
    Boolean setAuth(@RequestPart("roleId") Integer roleId,
                    @RequestPart(value = "authIdList", required = false) List<Integer> authIdList);
}