package com.userManager.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.base.common.service.impl.BaseServiceImpl;
import com.base.common.util.ExceptionUtil;
import com.userManager.auth.entity.UserRole;
import com.userManager.auth.mapper.UserRoleMapper;
import com.userManager.auth.service.UserRoleService;
import com.userManager.user.entity.User;
import com.userManager.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户的角色服务接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@Service
public class UserRoleServiceImpl
        extends BaseServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Value("${userManagerService.mybatisBatchSize}")
    private Integer mybatisBatchSize;

    @Autowired
    private UserService userService;

    @Override
    public List<UserRole> selectByUserId(Integer userId) {
        if(userId == null){
            ExceptionUtil.validError("用户ID不能为空！");
        }

        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        return select(userRole);
    }

    @Override
    public List<User> selectUserByRoleId(Integer roleId) {
        if(roleId == null){
            ExceptionUtil.validError("角色ID不能为空！");
        }

        UserRole userRole = new UserRole();
        userRole.setRoleId(roleId);
        List<UserRole> userRoleList = select(userRole);
        List<Integer> userIdList = new ArrayList<>(userRoleList.size());
        for(UserRole mUserRole : userRoleList){
            userIdList.add(mUserRole.getUserId());
        }

        return userService.selectByUserIdList(userIdList);
    }

    @Override
    public Boolean setRole(Integer userId, List<Integer> roleIdList) {
        if(userId == null){
            ExceptionUtil.validError("用户ID不能为空！");
        }

        UserRole userRole = new UserRole();
        userRole.setUserId(userId);

        // 先删除原来所有的权限
        Wrapper<UserRole> userDeptWrapper = new QueryWrapper<>(userRole);
        remove(userDeptWrapper);

        List<UserRole> userRoleList = new ArrayList<>(roleIdList.size());
        for(Integer roleId : roleIdList){
            UserRole mUserRole = new UserRole();
            mUserRole.setRoleId(roleId);
            mUserRole.setUserId(userId);
            userRoleList.add(mUserRole);
        }

        // 把数据批量插入
        return saveBatch(userRoleList, mybatisBatchSize);
    }
}