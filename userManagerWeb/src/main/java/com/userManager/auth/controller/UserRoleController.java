package com.userManager.auth.controller;

import com.base.common.controller.BaseController;
import com.base.common.util.ExceptionUtil;
import com.base.common.vo.Response;
import com.userManager.auth.api.UserRoleApi;
import com.userManager.auth.entity.UserRole;
import com.userManager.user.entity.User;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户的角色表控制层
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@RequestMapping("${urlHead}/userRole")
@RestController
@Slf4j
@Api(tags = "用户的角色管理")
@ApiResponses({@ApiResponse(code = 500, message = "服务器内部错误")})
public class UserRoleController extends BaseController {
    /**
     * 用户的角色管理服务
     */
    @Autowired
    UserRoleApi userRoleApi;

    /**
     * 给某个用户设置角色
     * @param userId 用户ID
     * @param roleIds 角色ID，用逗号拼接
     * @return
     */
    @ApiOperation(value = "给某个用户设置角色",notes = "给某个用户设置角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name="userId", value ="用户ID", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name="roleIds", value ="角色ID，用逗号拼接", dataType = "String", paramType = "query")
    })
    @PostMapping("/setDept")
    public ResponseEntity<Response> setDept(Integer userId, String roleIds){
        log.info("给某个用户设置角色");

        List<Integer> roleIdList = new ArrayList<>();
        if(StringUtils.isNotEmpty(roleIds)){
            try{
                String[] roleIdArray = roleIds.split(",");
                for(String roleId : roleIdArray){
                    roleIdList.add(Integer.parseInt(roleId));
                }
            }catch (Exception e){
                ExceptionUtil.validError("请输出正确的角色ID！");
            }
        }

        boolean result = userRoleApi.setRole(userId, roleIdList);

        return updateResponse(result);
    }

    /**
     * 根据用户ID获取用户对应的角色列表
     * @param userId 用户ID
     * @return
     */
    @ApiOperation(value = "根据用户ID获取用户对应的角色列表",notes = "根据用户ID获取用户对应的角色列表")
    @ApiImplicitParam(name="userId", value ="用户ID", required = true, dataType = "int", paramType = "query")
    @GetMapping("/selectByUserId")
    public ResponseEntity<Response<List<UserRole>>> selectByUserId(Integer userId){
        log.info("根据用户ID获取用户对应的角色列表");

        // 根据用户ID获取用户对应的部门列表
        List<UserRole> userDeptList = userRoleApi.selectByUserId(userId);

        return responseOk(userDeptList);
    }

    /**
     * 根据角色ID获取用户列表
     * @param roleId 角色ID
     * @return
     */
    @ApiOperation(value = "根据角色ID获取用户列表",notes = "根据角色ID获取用户列表")
    @ApiImplicitParam(name="roleId", value ="角色ID", required = true, dataType = "int", paramType = "query")
    @GetMapping("/selectByRoleId")
    public ResponseEntity<Response<List<User>>> selectUserByRoleId(Integer roleId){
        log.info("根据角色ID获取用户列表");

        // 根据信息获取角色授权表分页信息
        List<User> userList = userRoleApi.selectUserByRoleId(roleId);

        return responseOk(userList);
    }
}
