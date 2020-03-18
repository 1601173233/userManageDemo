package com.userManager.auth.controller;

import com.base.common.util.ExceptionUtil;
import com.userManager.auth.entity.RoleAuth;
import com.userManager.auth.api.RoleAuthApi;
import com.base.common.controller.BaseController;
import com.base.common.vo.Response;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色授权表表控制层
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@RequestMapping("${urlHead}/roleAuth")
@RestController
@Slf4j
@Api(tags = "角色授权表管理")
@ApiResponses({@ApiResponse(code = 500, message = "服务器内部错误")})
public class RoleAuthController extends BaseController {
    /**
     * 角色授权表管理服务
     */
    @Autowired
    RoleAuthApi roleAuthApi;

    /**
     * 给某个角色设置权限
     * @param roleId 角色ID
     * @param authIds 权限ID，用逗号拼接
     * @return
     */
    @ApiOperation(value = "给某个角色设置权限",notes = "给某个角色设置权限")
    @ApiImplicitParams({
            @ApiImplicitParam(name="roleId", value ="角色ID", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name="authIds", value ="权限ID，用逗号拼接", dataType = "String", paramType = "query")
    })
    @PostMapping("/setAuth")
    public ResponseEntity<Response> setAuth(Integer roleId, String authIds){
        log.info("给某个角色设置权限");

        List<Integer> authIdList = new ArrayList<>();
        if(StringUtils.isNotEmpty(authIds)){
            try{
                String[] authIdArray = authIds.split(",");
                for(String authId : authIdArray){
                    authIdList.add(Integer.parseInt(authId));
                }
            }catch (Exception e){
                ExceptionUtil.validError("请输出正确的权限ID！");
            }
        }

        boolean result = roleAuthApi.setAuth(roleId, authIdList);

        return updateResponse(result);
    }

    /**
     * 根据角色ID获取角色拥有的权限列表
     * @param roleId 角色ID
     * @return
     */
    @ApiOperation(value = "根据角色ID获取角色拥有的权限列表",notes = "根据角色ID获取角色拥有的权限列表")
    @ApiImplicitParam(name="roleId", value ="角色ID", required = true, dataType = "int", paramType = "query")
    @GetMapping("/selectByRoleId")
    public ResponseEntity<Response<List<RoleAuth>>> selectByRoleId(Integer roleId){
        log.info("根据角色ID获取角色拥有的权限列表");

        // 根据信息获取角色授权表分页信息
        List<RoleAuth> roleAuthList = roleAuthApi.selectByRoleId(roleId);

        return responseOk(roleAuthList);
    }
}
