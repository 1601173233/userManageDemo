package com.userManager.auth.controller;

import com.userManager.auth.entity.RoleAuth;
import com.userManager.auth.api.RoleAuthApi;
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
     * 根据 id 获取角色授权表信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据 id 获取角色授权表信息",notes = "根据 id 获取角色授权表信息")
    @ApiImplicitParam(name="id", value ="id", required = true, dataType = "String", paramType = "query")
    @GetMapping("/getById")
    public ResponseEntity<Response<RoleAuth>> getById(String id){
        log.info("根据 id 获取角色授权表信息");

        RoleAuth result = roleAuthApi.getById(id);

        // 根据id获取记录
        return responseOk(result);
    }

    /**
     * 根据 id 删除角色授权表信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据 id 删除角色授权表信息",notes = "根据 id 删除角色授权表信息")
    @ApiImplicitParam(name="id", value ="id", required = true, dataType = "String", paramType = "query")
    @DeleteMapping("/removeById")
    public ResponseEntity<Response> removeById(String id){
        log.info("根据 id 删除角色授权表信息");

        // 删除对应的记录
        boolean result = roleAuthApi.removeById(id);

        return updateResponse(result);
    }

    /**
     * 新增角色授权表信息
     * @param roleAuth 角色授权表信息
     * @return
     */
    @ApiOperation(value = "新增角色授权表信息",notes = "新增角色授权表信息")
    @PostMapping("/save")
    public ResponseEntity<Response> save(@Validated({Insert.class}) RoleAuth roleAuth){
        log.info("新增角色授权表信息");

        // 新增一条记录
        boolean result = roleAuthApi.save(roleAuth);

        return updateResponse(result);
    }

    /**
     * 更新角色授权表信息
     * @param roleAuth 角色授权表信息
     * @return
     */
    @ApiOperation(value = "更新角色授权表信息",notes = "更新角色授权表信息")
    @PutMapping("/updateById")
    public ResponseEntity<Response> updateById(@Validated({Update.class}) RoleAuth roleAuth){
        log.info("更新角色授权表信息");

        // 新增一条记录
        boolean result = roleAuthApi.updateById(roleAuth);

        return updateResponse(result);
    }

    /**
     * 根据信息获取角色授权表信息单个对象
     * @param roleAuth 角色授权表信息
     * @return
     */
    @ApiOperation(value = "根据信息获取角色授权表信息单个对象",notes = "根据信息获取角色授权表信息单个对象")
    @GetMapping("/selectOne")
    public ResponseEntity<Response<RoleAuth>> selectOne(RoleAuth roleAuth){
        log.info("根据信息获取角色授权表信息单个对象");

        // 根据信息获取角色授权表信息列表
        RoleAuth entity = roleAuthApi.selectOne(roleAuth);

        return responseOk(entity);
    }

    /**
     * 根据信息获取角色授权表信息列表
     * @param roleAuth 角色授权表信息
     * @return
     */
    @ApiOperation(value = "根据信息获取角色授权表信息列表",notes = "根据信息获取角色授权表信息列表")
    @GetMapping("/select")
    public ResponseEntity<Response<List<RoleAuth>>> select(RoleAuth roleAuth){
        log.info("根据信息获取角色授权表信息列表");

        // 根据信息获取角色授权表信息列表
        List<RoleAuth> list = roleAuthApi.select(roleAuth);

        return responseOk(list);
    }

    /**
     * 根据信息获取角色授权表分页信息
     * @param roleAuth 角色授权表信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @ApiOperation(value = "根据信息获取角色授权表信息分页信息",notes = "根据信息获取角色授权表分页信息")
    @GetMapping("/getPage")
    public ResponseEntity<Response<PageResultVo<RoleAuth>>> getPage(RoleAuth roleAuth, PageParamsVo pageParamsVo){
        log.info("根据信息获取角色授权表分页信息");

        // 根据信息获取角色授权表分页信息
        PageResultVo<RoleAuth> page = roleAuthApi.getPage(roleAuth, pageParamsVo);

        return responseOk(page);
    }
}
