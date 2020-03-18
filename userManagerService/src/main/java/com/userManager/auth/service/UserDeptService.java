package com.userManager.auth.service;

import com.base.common.service.BaseService;
import com.userManager.auth.entity.UserDept;
import com.userManager.user.entity.User;

import java.util.List;

/**
 * 用户的部门服务接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
public interface UserDeptService extends BaseService<UserDept>{
    /**
     * 根据用户ID获取用户对应的部门列表
     */
    List<UserDept> selectByUserId(Integer userId);

    /**
     * 根据部门ID获取在该部门的用户列表
     */
    List<User> selectUserByDeptId(Integer deptId);

    /**
     * 给某个用户设置部门
     */
    Boolean setDept(Integer userId, List<Integer> deptIdList);

}