package com.userManager.user.controller;

import com.userManager.user.api.UserInfoApi;
import com.userManager.user.entity.UserInfo;
import com.userManager.user.enums.LoginResultType;
import com.userManager.user.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * 用户登录服务控制层
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@RestController
@Slf4j
public class UserInfoController implements UserInfoApi {
    /**
     * 用户管理服务
     */
    @Autowired
    UserInfoService userInfoService;


    @Override
    public LoginResultType login(String userName, String password) {
        return null;
    }

    @Override
    public UserInfo getUserInfo(String userName) {
        return null;
    }

    @Override
    public Set<String> getAuth(String userName) {
        return null;
    }
}
