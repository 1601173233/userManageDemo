package com.userManager.auth.service.impl;

import com.base.common.service.impl.BaseServiceImpl;
import com.userManager.auth.entity.UserRole;
import com.userManager.auth.mapper.UserRoleMapper;
import com.userManager.auth.service.UserRoleService;
import com.base.common.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户的角色服务接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@Service
public class UserRoleServiceImpl
        extends BaseServiceImpl<UserRole, UserRoleMapper> implements UserRoleService {


}