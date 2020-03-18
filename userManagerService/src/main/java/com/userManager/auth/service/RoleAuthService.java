package com.userManager.auth.service;

import com.base.common.service.BaseService;
import com.userManager.auth.entity.RoleAuth;

import java.util.List;

/**
 * 角色授权表服务接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
public interface RoleAuthService extends BaseService<RoleAuth>{
    /**
     * 根据角色ID获取角色拥有的权限列表
     */
    List<RoleAuth> selectByRoleId(Integer roleId);

    /**
     * 给某个角色设置权限
     */
    Boolean setAuth(Integer roleId, List<Integer> authIdList);

}