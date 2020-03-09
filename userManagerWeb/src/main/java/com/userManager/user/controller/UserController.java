package com.userManager.user.controller;

import com.userManager.user.entity.User;
import com.userManager.user.api.UserApi;
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
 * 用户表控制层
 *
 * @author : huangyujie
 * @version : 2020年03月09日
 * @since
 */
@RequestMapping("${urlHead}/user")
@RestController
@Slf4j
@Api(tags = "用户管理")
@ApiResponses({@ApiResponse(code = 500, message = "服务器内部错误")})
public class UserController extends BaseController {
    /**
     * 用户管理服务
     */
    @Autowired
    UserApi userApi;

    /**
     * 根据 id 获取用户信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据 id 获取用户信息",notes = "根据 id 获取用户信息")
    @ApiImplicitParam(name="id", value ="id", required = true, dataType = "String", paramType = "query")
    @GetMapping("/getById")
    public ResponseEntity<Response<User>> getById(String id){
        log.info("根据 id 获取用户信息");

        User result = userApi.getById(id);

        // 根据id获取记录
        return responseOk(result);
    }

    /**
     * 根据 id 删除用户信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据 id 删除用户信息",notes = "根据 id 删除用户信息")
    @ApiImplicitParam(name="id", value ="id", required = true, dataType = "String", paramType = "query")
    @DeleteMapping("/removeById")
    public ResponseEntity<Response> removeById(String id){
        log.info("根据 id 删除用户信息");

        // 删除对应的记录
        boolean result = userApi.removeById(id);

        return updateResponse(result);
    }

    /**
     * 新增用户信息
     * @param user 用户信息
     * @return
     */
    @ApiOperation(value = "新增用户信息",notes = "新增用户信息")
    @PostMapping("/save")
    public ResponseEntity<Response> save(@Validated({Insert.class}) User user){
        log.info("新增用户信息");

        // 新增一条记录
        boolean result = userApi.save(user);

        return updateResponse(result);
    }

    /**
     * 更新用户信息
     * @param user 用户信息
     * @return
     */
    @ApiOperation(value = "更新用户信息",notes = "更新用户信息")
    @PutMapping("/updateById")
    public ResponseEntity<Response> updateById(@Validated({Update.class}) User user){
        log.info("更新用户信息");

        // 新增一条记录
        boolean result = userApi.updateById(user);

        return updateResponse(result);
    }

    /**
     * 根据信息获取用户信息单个对象
     * @param user 用户信息
     * @return
     */
    @ApiOperation(value = "根据信息获取用户信息单个对象",notes = "根据信息获取用户信息单个对象")
    @GetMapping("/selectOne")
    public ResponseEntity<Response<User>> selectOne(User user){
        log.info("根据信息获取用户信息单个对象");

        // 根据信息获取用户信息列表
        User entity = userApi.selectOne(user);

        return responseOk(entity);
    }

    /**
     * 根据信息获取用户信息列表
     * @param user 用户信息
     * @return
     */
    @ApiOperation(value = "根据信息获取用户信息列表",notes = "根据信息获取用户信息列表")
    @GetMapping("/select")
    public ResponseEntity<Response<List<User>>> select(User user){
        log.info("根据信息获取用户信息列表");

        // 根据信息获取用户信息列表
        List<User> list = userApi.select(user);

        return responseOk(list);
    }

    /**
     * 根据信息获取用户分页信息
     * @param user 用户信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @ApiOperation(value = "根据信息获取用户信息分页信息",notes = "根据信息获取用户分页信息")
    @GetMapping("/getPage")
    public ResponseEntity<Response<PageResultVo<User>>> getPage(User user, PageParamsVo pageParamsVo){
        log.info("根据信息获取用户分页信息");

        // 根据信息获取用户分页信息
        PageResultVo<User> page = userApi.getPage(user, pageParamsVo);

        return responseOk(page);
    }
}
