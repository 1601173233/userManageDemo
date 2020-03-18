package com.userManager.auth.controller;

import com.userManager.auth.api.RoleAuthApi;
import com.userManager.auth.entity.RoleAuth;
import com.userManager.auth.service.RoleAuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 角色授权表表服务控制层
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@RestController
@Slf4j
public class RoleAuthController implements RoleAuthApi {

    @Autowired
    private RoleAuthService roleAuthService;

    @Override
    public List<RoleAuth> selectByRoleId(Integer roleId) {
        return roleAuthService.selectByRoleId(roleId);
    }

    @Override
    public Boolean setAuth(Integer roleId, List<Integer> authIdList) {
        return roleAuthService.setAuth(roleId, authIdList);
    }
}
