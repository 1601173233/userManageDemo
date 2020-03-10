package com.userManager.auth.controller;

import com.userManager.auth.entity.Auth;
import com.userManager.auth.api.AuthApi;
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
 * 权限管理表控制层
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@RequestMapping("${urlHead}/auth")
@RestController
@Slf4j
@Api(tags = "权限管理管理")
@ApiResponses({@ApiResponse(code = 500, message = "服务器内部错误")})
public class AuthController extends BaseController {
    /**
     * 权限管理管理服务
     */
    @Autowired
    AuthApi authApi;

    /**
     * 根据 id 获取权限管理信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据 id 获取权限管理信息",notes = "根据 id 获取权限管理信息")
    @ApiImplicitParam(name="id", value ="id", required = true, dataType = "String", paramType = "query")
    @GetMapping("/getById")
    public ResponseEntity<Response<Auth>> getById(String id){
        log.info("根据 id 获取权限管理信息");

        Auth result = authApi.getById(id);

        // 根据id获取记录
        return responseOk(result);
    }

    /**
     * 根据 id 删除权限管理信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据 id 删除权限管理信息",notes = "根据 id 删除权限管理信息")
    @ApiImplicitParam(name="id", value ="id", required = true, dataType = "String", paramType = "query")
    @DeleteMapping("/removeById")
    public ResponseEntity<Response> removeById(String id){
        log.info("根据 id 删除权限管理信息");

        // 删除对应的记录
        boolean result = authApi.removeById(id);

        return updateResponse(result);
    }

    /**
     * 新增权限管理信息
     * @param auth 权限管理信息
     * @return
     */
    @ApiOperation(value = "新增权限管理信息",notes = "新增权限管理信息")
    @PostMapping("/save")
    public ResponseEntity<Response> save(@Validated({Insert.class}) Auth auth){
        log.info("新增权限管理信息");

        // 新增一条记录
        boolean result = authApi.save(auth);

        return updateResponse(result);
    }

    /**
     * 更新权限管理信息
     * @param auth 权限管理信息
     * @return
     */
    @ApiOperation(value = "更新权限管理信息",notes = "更新权限管理信息")
    @PutMapping("/updateById")
    public ResponseEntity<Response> updateById(@Validated({Update.class}) Auth auth){
        log.info("更新权限管理信息");

        // 新增一条记录
        boolean result = authApi.updateById(auth);

        return updateResponse(result);
    }

    /**
     * 根据信息获取权限管理信息单个对象
     * @param auth 权限管理信息
     * @return
     */
    @ApiOperation(value = "根据信息获取权限管理信息单个对象",notes = "根据信息获取权限管理信息单个对象")
    @GetMapping("/selectOne")
    public ResponseEntity<Response<Auth>> selectOne(Auth auth){
        log.info("根据信息获取权限管理信息单个对象");

        // 根据信息获取权限管理信息列表
        Auth entity = authApi.selectOne(auth);

        return responseOk(entity);
    }

    /**
     * 根据信息获取权限管理信息列表
     * @param auth 权限管理信息
     * @return
     */
    @ApiOperation(value = "根据信息获取权限管理信息列表",notes = "根据信息获取权限管理信息列表")
    @GetMapping("/select")
    public ResponseEntity<Response<List<Auth>>> select(Auth auth){
        log.info("根据信息获取权限管理信息列表");

        // 根据信息获取权限管理信息列表
        List<Auth> list = authApi.select(auth);

        return responseOk(list);
    }

    /**
     * 根据信息获取权限管理分页信息
     * @param auth 权限管理信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @ApiOperation(value = "根据信息获取权限管理信息分页信息",notes = "根据信息获取权限管理分页信息")
    @GetMapping("/getPage")
    public ResponseEntity<Response<PageResultVo<Auth>>> getPage(Auth auth, PageParamsVo pageParamsVo){
        log.info("根据信息获取权限管理分页信息");

        // 根据信息获取权限管理分页信息
        PageResultVo<Auth> page = authApi.getPage(auth, pageParamsVo);

        return responseOk(page);
    }
}
