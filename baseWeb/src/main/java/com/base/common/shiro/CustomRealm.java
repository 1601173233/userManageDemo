package com.base.common.shiro;

import com.base.common.enums.LoginResultType;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 *  身份信息配置类
 */
public class CustomRealm extends AuthorizingRealm {
    /** 用户信息接口 */
    private UserInfoApi userInfoApi;

    /**
     * 设置
     */
    @Autowired
    private void setUserInfoApi(UserInfoApi userInfoApi) {
        this.userInfoApi = userInfoApi;
    }

    /**
     * 获取身份验证信息
     * Shiro中，最终是通过 Realm 来获取应用程序中的用户、角色及权限信息的。
     *
     * @param authenticationToken 用户身份信息 token
     * @return 返回封装了用户信息的 AuthenticationInfo 实例
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String password = new String((char[]) token.getCredentials());

        // 从数据库获取对应用户名密码的用户
        LoginResultType loginResultType = userInfoApi.login(token.getUsername(), password);
        if (loginResultType.equals(loginResultType.NOT_EXISTS)) {
            throw new AccountException("用户名不正确");
        } else if (loginResultType.equals(loginResultType.PASSWORD_ERROR)) {
            throw new AccountException("密码不正确");
        }
        return new SimpleAuthenticationInfo(token.getPrincipal(), password, getName());
    }

    /**
     * 获取授权信息
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获得该用户角色
        Set<String> authSet = userInfoApi.getAuth(username);
        //设置该用户拥有的角色
        info.setRoles(authSet);
        return info;
    }
}