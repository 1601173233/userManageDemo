package com.userManager.auth.controller;

import com.base.common.controller.BaseController;
import com.base.common.util.ExceptionUtil;
import com.base.common.vo.Response;
import com.userManager.auth.api.UserDeptApi;
import com.userManager.auth.entity.UserDept;
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
 * 用户的部门表控制层
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@RequestMapping("${urlHead}/userDept")
@RestController
@Slf4j
@Api(tags = "用户的部门管理")
@ApiResponses({@ApiResponse(code = 500, message = "服务器内部错误")})
public class UserDeptController extends BaseController {
    /**
     * 用户的部门管理服务
     */
    @Autowired
    UserDeptApi userDeptApi;

    /**
     * 给某个用户设置部门
     * @param userId 用户ID
     * @param deptIds 部门ID，用逗号拼接
     * @return
     */
    @ApiOperation(value = "给某个用户设置部门",notes = "给某个用户设置部门")
    @ApiImplicitParams({
            @ApiImplicitParam(name="userId", value ="用户ID", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name="deptIds", value ="部门ID，用逗号拼接", dataType = "String", paramType = "query")
    })
    @PostMapping("/setDept")
    public ResponseEntity<Response> setDept(Integer userId, String deptIds){
        log.info("给某个用户设置部门");

        List<Integer> authIdList = new ArrayList<>();
        if(StringUtils.isNotEmpty(deptIds)){
            try{
                String[] deptIdArray = deptIds.split(",");
                for(String authId : deptIdArray){
                    authIdList.add(Integer.parseInt(authId));
                }
            }catch (Exception e){
                ExceptionUtil.validError("请输出正确的部门ID！");
            }
        }

        boolean result = userDeptApi.setDept(userId, authIdList);

        return updateResponse(result);
    }

    /**
     * 根据用户ID获取用户对应的部门列表
     * @param userId 用户ID
     * @return
     */
    @ApiOperation(value = "根据用户ID获取用户对应的部门列表",notes = "根据用户ID获取用户对应的部门列表")
    @ApiImplicitParam(name="userId", value ="用户ID", required = true, dataType = "int", paramType = "query")
    @GetMapping("/selectByUserId")
    public ResponseEntity<Response<List<UserDept>>> selectByUserId(Integer userId){
        log.info("根据用户ID获取用户对应的部门列表");

        // 根据用户ID获取用户对应的部门列表
        List<UserDept> userDeptList = userDeptApi.selectByUserId(userId);

        return responseOk(userDeptList);
    }

    /**
     * 根据部门ID获取在该部门的用户列表
     * @param deptId 部门ID
     * @return
     */
    @ApiOperation(value = "根据部门ID获取在该部门的用户列表",notes = "根据部门ID获取在该部门的用户列表")
    @ApiImplicitParam(name="deptId", value ="部门ID", required = true, dataType = "int", paramType = "query")
    @GetMapping("/selectUserByDeptId")
    public ResponseEntity<Response<List<User>>> selectUserByDeptId(Integer deptId){
        log.info("根据部门ID获取在该部门的用户列表");

        // 根据信息获取角色授权表分页信息
        List<User> userList = userDeptApi.selectUserByDeptId(deptId);

        return responseOk(userList);
    }
}
