package com.userManager.auth.controller;

import com.userManager.auth.api.UserDeptApi;
import com.userManager.auth.entity.UserDept;
import com.userManager.auth.service.UserDeptService;
import com.userManager.user.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户的部门表服务控制层
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@RestController
@Slf4j
public class UserDeptController implements UserDeptApi {

    @Autowired
    private UserDeptService userDeptService;

    @Override
    public List<UserDept> selectByUserId(Integer userId) {
        return userDeptService.selectByUserId(userId);
    }

    @Override
    public List<User> selectUserByDeptId(Integer deptId) {
        return userDeptService.selectUserByDeptId(deptId);
    }

    @Override
    public Boolean setDept(Integer userId, List<Integer> deptIdList) {
        return userDeptService.setDept(userId, deptIdList);
    }
}
