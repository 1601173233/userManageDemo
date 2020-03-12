package com.userManager.user.api;

import com.userManager.user.entity.UserInfo;
import com.userManager.user.enums.LoginResultType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestPart;

import java.util.Set;

/**
 * 用户信息对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
public interface UserInfoApi {
    /**
     * 登录信息
     * @param userName
     * @return
     */
    @GetMapping(value = "/innerApi/user/userInfoApi/login")
    LoginResultType login(@RequestPart("dept") String userName,
                          @RequestPart("dept") String password);

    /**
     * 获取用户信息
     * @param userName
     * @return
     */
    @GetMapping(value = "/innerApi/user/userInfoApi/getUserInfo")
    UserInfo getUserInfo(@RequestPart("userName") String userName);

    /**
     * 获取用户拥有的权限列表
     * @param userName
     * @return
     */
    @GetMapping(value = "/innerApi/user/userInfoApi/auth")
    Set<String> getAuth(@RequestPart("userName") String userName);
}