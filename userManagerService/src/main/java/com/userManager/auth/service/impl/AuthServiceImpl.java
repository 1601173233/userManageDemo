package com.userManagerauth.service.impl;

import com.base.common.service.impl.BaseServiceImpl;
import com.userManagerauth.entity.Auth;
import com.userManagerauth.mapper.AuthMapper;
import com.userManagerauth.service.AuthService;
import com.base.common.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 权限管理服务接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@Service
public class AuthServiceImpl
        extends BaseServiceImpl<Auth, AuthMapper> implements AuthService {


}