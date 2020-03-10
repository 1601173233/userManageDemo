package com.userManager.user.controller;

import com.userManager.user.entity.Role;
import com.userManager.user.api.RoleApi;
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
 * 角色表控制层
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@RequestMapping("${urlHead}/role")
@RestController
@Slf4j
@Api(tags = "角色管理")
@ApiResponses({@ApiResponse(code = 500, message = "服务器内部错误")})
public class RoleController extends BaseController {
    /**
     * 角色管理服务
     */
    @Autowired
    RoleApi roleApi;

    /**
     * 根据 id 获取角色信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据 id 获取角色信息",notes = "根据 id 获取角色信息")
    @ApiImplicitParam(name="id", value ="id", required = true, dataType = "String", paramType = "query")
    @GetMapping("/getById")
    public ResponseEntity<Response<Role>> getById(String id){
        log.info("根据 id 获取角色信息");

        Role result = roleApi.getById(id);

        // 根据id获取记录
        return responseOk(result);
    }

    /**
     * 根据 id 删除角色信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据 id 删除角色信息",notes = "根据 id 删除角色信息")
    @ApiImplicitParam(name="id", value ="id", required = true, dataType = "String", paramType = "query")
    @DeleteMapping("/removeById")
    public ResponseEntity<Response> removeById(String id){
        log.info("根据 id 删除角色信息");

        // 删除对应的记录
        boolean result = roleApi.removeById(id);

        return updateResponse(result);
    }

    /**
     * 新增角色信息
     * @param role 角色信息
     * @return
     */
    @ApiOperation(value = "新增角色信息",notes = "新增角色信息")
    @PostMapping("/save")
    public ResponseEntity<Response> save(@Validated({Insert.class}) Role role){
        log.info("新增角色信息");

        // 新增一条记录
        boolean result = roleApi.save(role);

        return updateResponse(result);
    }

    /**
     * 更新角色信息
     * @param role 角色信息
     * @return
     */
    @ApiOperation(value = "更新角色信息",notes = "更新角色信息")
    @PutMapping("/updateById")
    public ResponseEntity<Response> updateById(@Validated({Update.class}) Role role){
        log.info("更新角色信息");

        // 新增一条记录
        boolean result = roleApi.updateById(role);

        return updateResponse(result);
    }

    /**
     * 根据信息获取角色信息单个对象
     * @param role 角色信息
     * @return
     */
    @ApiOperation(value = "根据信息获取角色信息单个对象",notes = "根据信息获取角色信息单个对象")
    @GetMapping("/selectOne")
    public ResponseEntity<Response<Role>> selectOne(Role role){
        log.info("根据信息获取角色信息单个对象");

        // 根据信息获取角色信息列表
        Role entity = roleApi.selectOne(role);

        return responseOk(entity);
    }

    /**
     * 根据信息获取角色信息列表
     * @param role 角色信息
     * @return
     */
    @ApiOperation(value = "根据信息获取角色信息列表",notes = "根据信息获取角色信息列表")
    @GetMapping("/select")
    public ResponseEntity<Response<List<Role>>> select(Role role){
        log.info("根据信息获取角色信息列表");

        // 根据信息获取角色信息列表
        List<Role> list = roleApi.select(role);

        return responseOk(list);
    }

    /**
     * 根据信息获取角色分页信息
     * @param role 角色信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @ApiOperation(value = "根据信息获取角色信息分页信息",notes = "根据信息获取角色分页信息")
    @GetMapping("/getPage")
    public ResponseEntity<Response<PageResultVo<Role>>> getPage(Role role, PageParamsVo pageParamsVo){
        log.info("根据信息获取角色分页信息");

        // 根据信息获取角色分页信息
        PageResultVo<Role> page = roleApi.getPage(role, pageParamsVo);

        return responseOk(page);
    }
}
