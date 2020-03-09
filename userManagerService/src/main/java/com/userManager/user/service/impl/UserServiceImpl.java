package com.userManager.user.service.impl;

import com.base.common.service.impl.BaseServiceImpl;
import com.userManager.user.entity.User;
import com.userManager.user.mapper.UserMapper;
import com.userManager.user.service.UserService;
import com.base.common.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户服务接口
 *
 * @author : huangyujie
 * @version : 2020年03月06日
 * @since
 */
@Service
public class UserServiceImpl
        extends BaseServiceImpl<User, UserMapper> implements UserService {


}