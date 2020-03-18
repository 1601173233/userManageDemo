package com.userManager.user.service.impl;

import com.base.common.service.impl.BaseServiceImpl;
import com.base.common.util.ExceptionUtil;
import com.userManager.user.entity.Role;
import com.userManager.user.enums.RoleType;
import com.userManager.user.mapper.RoleMapper;
import com.userManager.user.service.RoleService;
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

    /**
     *
     * @return
     */
    public boolean save(Role role){
        // 系统角色不需要保存部门
        if(role.getRoleType().equals(RoleType.SYSTEM.getCode())){
            role.setDeptId(null);
        }else if(role.getRoleType().equals(RoleType.DEPT.getCode())){
            if(role.getDeptId() == null){
                ExceptionUtil.validError("部门ID不能为空！");
            }
        }
        return super.save(role);
    }

}