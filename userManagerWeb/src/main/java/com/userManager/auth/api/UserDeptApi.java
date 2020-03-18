package com.userManager.auth.api;

import com.userManager.auth.entity.UserDept;
import com.userManager.user.entity.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

/**
 * 用户的部门对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@FeignClient(name = "${serviceName.gateway}/${serviceName.userManage}")
public interface UserDeptApi{
    /**
     * 根据用户ID获取用户对应的部门列表
     */
    @RequestLine(value = "GET /innerApi/auth/userDeptApi/selectByUserId")
    List<UserDept> selectByUserId(@Param("userId") Integer userId);

    /**
     * 根据部门ID获取在该部门的用户列表
     */
    @RequestLine(value = "GET /innerApi/auth/userDeptApi/selectUserByDeptId")
    List<User> selectUserByDeptId(@Param("deptId") Integer deptId);

    /**
     * 给某个用户设置部门
     */
    @RequestLine(value = "POST /innerApi/auth/userDeptApi/setDept")
    Boolean setDept(@Param(value = "userId") Integer userId,
                    @Param(value = "deptIdList") List<Integer> deptIdList);
}