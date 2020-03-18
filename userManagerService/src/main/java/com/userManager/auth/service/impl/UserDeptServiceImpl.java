package com.userManager.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.base.common.service.impl.BaseServiceImpl;
import com.base.common.util.ExceptionUtil;
import com.userManager.auth.entity.UserDept;
import com.userManager.auth.mapper.UserDeptMapper;
import com.userManager.auth.service.UserDeptService;
import com.userManager.user.entity.User;
import com.userManager.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户的部门服务接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@Service
public class UserDeptServiceImpl
        extends BaseServiceImpl<UserDeptMapper, UserDept> implements UserDeptService {

    @Value("${userManagerService.mybatisBatchSize}")
    private Integer mybatisBatchSize;

    @Autowired
    private UserService userService;

    @Override
    public List<UserDept> selectByUserId(Integer userId) {
        if(userId == null){
            ExceptionUtil.validError("用户ID不能为空！");
        }

        UserDept userDept = new UserDept();
        userDept.setUserId(userId);
        return select(userDept);
    }

    @Override
    public List<User> selectUserByDeptId(Integer deptId) {
        if(deptId == null){
            ExceptionUtil.validError("部门ID不能为空！");
        }

        UserDept userDept = new UserDept();
        userDept.setDeptId(deptId);
        List<UserDept> userDeptList = select(userDept);
        List<Integer> userIdList = new ArrayList<>(userDeptList.size());
        for(UserDept mUserDept : userDeptList){
            userIdList.add(mUserDept.getUserId());
        }

        return userService.selectByUserIdList(userIdList);
    }

    @Override
    public Boolean setDept(Integer userId, List<Integer> deptIdList) {
        if(userId == null){
            ExceptionUtil.validError("用户ID不能为空！");
        }

        UserDept userDept = new UserDept();
        userDept.setUserId(userId);

        // 先删除原来所有的权限
        Wrapper<UserDept> userDeptWrapper = new QueryWrapper<>(userDept);
        remove(userDeptWrapper);

        List<UserDept> userDeptList = new ArrayList<>(deptIdList.size());
        for(Integer deptId : deptIdList){
            UserDept mUserDept = new UserDept();
            mUserDept.setDeptId(deptId);
            mUserDept.setUserId(userId);
            userDeptList.add(mUserDept);
        }

        // 把数据批量插入
        return saveBatch(userDeptList, mybatisBatchSize);
    }
}