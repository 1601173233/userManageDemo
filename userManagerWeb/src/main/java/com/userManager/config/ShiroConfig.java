package com.userManager.config;

import com.base.common.config.BaseShiroConfig;

import java.util.Map;

/**
 * shiro配置类
 * @author huangyujie
 * @version 2019/7/11
 */
//@Configuration
public class ShiroConfig extends BaseShiroConfig {
    /**
     * 权限控制类
     * @param filterChainDefinitionMap
     */
    protected void shiroFilter(Map<String, String> filterChainDefinitionMap){
        //游客，开发权限
        filterChainDefinitionMap.put("/guest/**", "anon");
        //用户，需要角色权限 “user”
        filterChainDefinitionMap.put("/user/**", "roles[user]");
        //管理员，需要角色权限 “admin”
        filterChainDefinitionMap.put("/admin/**", "roles[admin]");
        //开放登陆接口
        filterChainDefinitionMap.put("/login", "anon");
        //其余接口一律拦截
        //主要这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截
        filterChainDefinitionMap.put("/**", "authc");
    }
}