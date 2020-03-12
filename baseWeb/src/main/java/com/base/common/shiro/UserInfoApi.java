package com.base.common.shiro;

import com.base.common.enums.LoginResultType;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.Set;

/**
 * 用户信息对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@FeignClient(name = "${serviceName.gateway}/${serviceName.userManage}")
public interface UserInfoApi {
    /**
     * 登录信息
     * @param userName
     * @return
     */
    @RequestLine(value = "GET /innerApi/user/userInfoApi/login")
    LoginResultType login(@Param("userName") String userName,
                          @Param("password") String password);

    /**
     * 获取用户信息
     * @param userName
     * @return
     */
    @RequestLine(value = "GET /innerApi/user/userInfoApi/getUserInfo")
    UserInfo getUserInfo(@Param("userName") String userName);

    /**
     * 获取用户拥有的权限列表
     * @param userName
     * @return
     */
    @RequestLine(value = "GET /innerApi/user/userInfoApi/auth")
    Set<String> getAuth(@Param("userName") String userName);
}