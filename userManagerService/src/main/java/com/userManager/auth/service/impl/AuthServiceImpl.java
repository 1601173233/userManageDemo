package com.userManager.auth.service.impl;

import com.base.common.service.impl.BaseServiceImpl;
import com.userManager.auth.entity.Auth;
import com.userManager.auth.mapper.AuthMapper;
import com.userManager.auth.service.AuthService;
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
        extends BaseServiceImpl<AuthMapper, Auth> implements AuthService {


}