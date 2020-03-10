package com.userManager.user.service.impl;

import com.base.common.service.impl.BaseServiceImpl;
import com.userManager.user.entity.Role;
import com.userManager.user.mapper.RoleMapper;
import com.userManager.user.service.RoleService;
import com.base.common.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色服务接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@Service
public class RoleServiceImpl
        extends BaseServiceImpl<Role, RoleMapper> implements RoleService {


}