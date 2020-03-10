package com.userManager.auth.controller;

import com.userManager.auth.entity.UserRole;
import com.userManager.auth.api.UserRoleApi;
import com.base.common.controller.BaseController;
import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.base.common.vo.Response;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.base.common.validType.Insert;
import com.base.common.validType.Update;
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
     * 根据 id 获取用户的角色信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据 id 获取用户的角色信息",notes = "根据 id 获取用户的角色信息")
    @ApiImplicitParam(name="id", value ="id", required = true, dataType = "String", paramType = "query")
    @GetMapping("/getById")
    public ResponseEntity<Response<UserRole>> getById(String id){
        log.info("根据 id 获取用户的角色信息");

        UserRole result = userRoleApi.getById(id);

        // 根据id获取记录
        return responseOk(result);
    }

    /**
     * 根据 id 删除用户的角色信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据 id 删除用户的角色信息",notes = "根据 id 删除用户的角色信息")
    @ApiImplicitParam(name="id", value ="id", required = true, dataType = "String", paramType = "query")
    @DeleteMapping("/removeById")
    public ResponseEntity<Response> removeById(String id){
        log.info("根据 id 删除用户的角色信息");

        // 删除对应的记录
        boolean result = userRoleApi.removeById(id);

        return updateResponse(result);
    }

    /**
     * 新增用户的角色信息
     * @param userRole 用户的角色信息
     * @return
     */
    @ApiOperation(value = "新增用户的角色信息",notes = "新增用户的角色信息")
    @PostMapping("/save")
    public ResponseEntity<Response> save(@Validated({Insert.class}) UserRole userRole){
        log.info("新增用户的角色信息");

        // 新增一条记录
        boolean result = userRoleApi.save(userRole);

        return updateResponse(result);
    }

    /**
     * 更新用户的角色信息
     * @param userRole 用户的角色信息
     * @return
     */
    @ApiOperation(value = "更新用户的角色信息",notes = "更新用户的角色信息")
    @PutMapping("/updateById")
    public ResponseEntity<Response> updateById(@Validated({Update.class}) UserRole userRole){
        log.info("更新用户的角色信息");

        // 新增一条记录
        boolean result = userRoleApi.updateById(userRole);

        return updateResponse(result);
    }

    /**
     * 根据信息获取用户的角色信息单个对象
     * @param userRole 用户的角色信息
     * @return
     */
    @ApiOperation(value = "根据信息获取用户的角色信息单个对象",notes = "根据信息获取用户的角色信息单个对象")
    @GetMapping("/selectOne")
    public ResponseEntity<Response<UserRole>> selectOne(UserRole userRole){
        log.info("根据信息获取用户的角色信息单个对象");

        // 根据信息获取用户的角色信息列表
        UserRole entity = userRoleApi.selectOne(userRole);

        return responseOk(entity);
    }

    /**
     * 根据信息获取用户的角色信息列表
     * @param userRole 用户的角色信息
     * @return
     */
    @ApiOperation(value = "根据信息获取用户的角色信息列表",notes = "根据信息获取用户的角色信息列表")
    @GetMapping("/select")
    public ResponseEntity<Response<List<UserRole>>> select(UserRole userRole){
        log.info("根据信息获取用户的角色信息列表");

        // 根据信息获取用户的角色信息列表
        List<UserRole> list = userRoleApi.select(userRole);

        return responseOk(list);
    }

    /**
     * 根据信息获取用户的角色分页信息
     * @param userRole 用户的角色信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @ApiOperation(value = "根据信息获取用户的角色信息分页信息",notes = "根据信息获取用户的角色分页信息")
    @GetMapping("/getPage")
    public ResponseEntity<Response<PageResultVo<UserRole>>> getPage(UserRole userRole, PageParamsVo pageParamsVo){
        log.info("根据信息获取用户的角色分页信息");

        // 根据信息获取用户的角色分页信息
        PageResultVo<UserRole> page = userRoleApi.getPage(userRole, pageParamsVo);

        return responseOk(page);
    }
}
