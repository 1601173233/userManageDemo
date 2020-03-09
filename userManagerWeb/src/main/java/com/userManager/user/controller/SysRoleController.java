package com.userManager.user.controller;

import com.userManager.user.entity.SysRole;
import com.userManager.user.api.SysRoleApi;
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
 * 系统角色表控制层
 *
 * @author : huangyujie
 * @version : 2020年03月09日
 * @since
 */
@RequestMapping("${urlHead}/sysRole")
@RestController
@Slf4j
@Api(tags = "系统角色管理")
@ApiResponses({@ApiResponse(code = 500, message = "服务器内部错误")})
public class SysRoleController extends BaseController {
    /**
     * 系统角色管理服务
     */
    @Autowired
    SysRoleApi sysRoleApi;

    /**
     * 根据 id 获取系统角色信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据 id 获取系统角色信息",notes = "根据 id 获取系统角色信息")
    @ApiImplicitParam(name="id", value ="id", required = true, dataType = "String", paramType = "query")
    @GetMapping("/getById")
    public ResponseEntity<Response<SysRole>> getById(String id){
        log.info("根据 id 获取系统角色信息");

        SysRole result = sysRoleApi.getById(id);

        // 根据id获取记录
        return responseOk(result);
    }

    /**
     * 根据 id 删除系统角色信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据 id 删除系统角色信息",notes = "根据 id 删除系统角色信息")
    @ApiImplicitParam(name="id", value ="id", required = true, dataType = "String", paramType = "query")
    @DeleteMapping("/removeById")
    public ResponseEntity<Response> removeById(String id){
        log.info("根据 id 删除系统角色信息");

        // 删除对应的记录
        boolean result = sysRoleApi.removeById(id);

        return updateResponse(result);
    }

    /**
     * 新增系统角色信息
     * @param sysRole 系统角色信息
     * @return
     */
    @ApiOperation(value = "新增系统角色信息",notes = "新增系统角色信息")
    @PostMapping("/save")
    public ResponseEntity<Response> save(@Validated({Insert.class}) SysRole sysRole){
        log.info("新增系统角色信息");

        // 新增一条记录
        boolean result = sysRoleApi.save(sysRole);

        return updateResponse(result);
    }

    /**
     * 更新系统角色信息
     * @param sysRole 系统角色信息
     * @return
     */
    @ApiOperation(value = "更新系统角色信息",notes = "更新系统角色信息")
    @PutMapping("/updateById")
    public ResponseEntity<Response> updateById(@Validated({Update.class}) SysRole sysRole){
        log.info("更新系统角色信息");

        // 新增一条记录
        boolean result = sysRoleApi.updateById(sysRole);

        return updateResponse(result);
    }

    /**
     * 根据信息获取系统角色信息单个对象
     * @param sysRole 系统角色信息
     * @return
     */
    @ApiOperation(value = "根据信息获取系统角色信息单个对象",notes = "根据信息获取系统角色信息单个对象")
    @GetMapping("/selectOne")
    public ResponseEntity<Response<SysRole>> selectOne(SysRole sysRole){
        log.info("根据信息获取系统角色信息单个对象");

        // 根据信息获取系统角色信息列表
        SysRole entity = sysRoleApi.selectOne(sysRole);

        return responseOk(entity);
    }

    /**
     * 根据信息获取系统角色信息列表
     * @param sysRole 系统角色信息
     * @return
     */
    @ApiOperation(value = "根据信息获取系统角色信息列表",notes = "根据信息获取系统角色信息列表")
    @GetMapping("/select")
    public ResponseEntity<Response<List<SysRole>>> select(SysRole sysRole){
        log.info("根据信息获取系统角色信息列表");

        // 根据信息获取系统角色信息列表
        List<SysRole> list = sysRoleApi.select(sysRole);

        return responseOk(list);
    }

    /**
     * 根据信息获取系统角色分页信息
     * @param sysRole 系统角色信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @ApiOperation(value = "根据信息获取系统角色信息分页信息",notes = "根据信息获取系统角色分页信息")
    @GetMapping("/getPage")
    public ResponseEntity<Response<PageResultVo<SysRole>>> getPage(SysRole sysRole, PageParamsVo pageParamsVo){
        log.info("根据信息获取系统角色分页信息");

        // 根据信息获取系统角色分页信息
        PageResultVo<SysRole> page = sysRoleApi.getPage(sysRole, pageParamsVo);

        return responseOk(page);
    }
}
