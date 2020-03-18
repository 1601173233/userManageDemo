package com.userManager.auth.api;

import com.userManager.auth.entity.UserDept;
import com.userManager.user.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;

import java.util.List;

/**
 * 用户的部门对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
public interface UserDeptApi{
    /**
     * 根据用户ID获取用户对应的部门列表
     */
    @GetMapping(value = "/innerApi/auth/userDeptApi/selectByUserId")
    List<UserDept> selectByUserId(Integer userId);

    /**
     * 根据部门ID获取在该部门的用户列表
     */
    @GetMapping(value = "/innerApi/auth/userDeptApi/selectUserByDeptId")
    List<User> selectUserByDeptId(Integer deptId);

    /**
     * 给某个用户设置部门
     */
    @PostMapping(value = "/innerApi/auth/userDeptApi/setDept")
    Boolean setDept(@RequestPart(value = "userId") Integer userId,
                    @RequestPart(value = "deptIdList", required = false) List<Integer> deptId);
}