package com.userManager.user.service.impl;

import com.base.common.service.impl.BaseServiceImpl;
import com.userManager.user.entity.UserRole;
import com.userManager.user.mapper.UserRoleMapper;
import com.userManager.user.service.UserRoleService;
import com.base.common.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户的角色服务接口
 *
 * @author : huangyujie
 * @version : 2020年03月06日
 * @since
 */
@Service
public class UserRoleServiceImpl
        extends BaseServiceImpl<UserRole, UserRoleMapper> implements UserRoleService {


}