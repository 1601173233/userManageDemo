package com.userManager.user.controller;

import com.userManager.user.entity.DeptRole;
import com.userManager.user.api.DeptRoleApi;
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
 * 部门角色表控制层
 *
 * @author : huangyujie
 * @version : 2020年03月09日
 * @since
 */
@RequestMapping("${urlHead}/deptRole")
@RestController
@Slf4j
@Api(tags = "部门角色管理")
@ApiResponses({@ApiResponse(code = 500, message = "服务器内部错误")})
public class DeptRoleController extends BaseController {
    /**
     * 部门角色管理服务
     */
    @Autowired
    DeptRoleApi deptRoleApi;

    /**
     * 根据 id 获取部门角色信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据 id 获取部门角色信息",notes = "根据 id 获取部门角色信息")
    @ApiImplicitParam(name="id", value ="id", required = true, dataType = "String", paramType = "query")
    @GetMapping("/getById")
    public ResponseEntity<Response<DeptRole>> getById(String id){
        log.info("根据 id 获取部门角色信息");

        DeptRole result = deptRoleApi.getById(id);

        // 根据id获取记录
        return responseOk(result);
    }

    /**
     * 根据 id 删除部门角色信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据 id 删除部门角色信息",notes = "根据 id 删除部门角色信息")
    @ApiImplicitParam(name="id", value ="id", required = true, dataType = "String", paramType = "query")
    @DeleteMapping("/removeById")
    public ResponseEntity<Response> removeById(String id){
        log.info("根据 id 删除部门角色信息");

        // 删除对应的记录
        boolean result = deptRoleApi.removeById(id);

        return updateResponse(result);
    }

    /**
     * 新增部门角色信息
     * @param deptRole 部门角色信息
     * @return
     */
    @ApiOperation(value = "新增部门角色信息",notes = "新增部门角色信息")
    @PostMapping("/save")
    public ResponseEntity<Response> save(@Validated({Insert.class}) DeptRole deptRole){
        log.info("新增部门角色信息");

        // 新增一条记录
        boolean result = deptRoleApi.save(deptRole);

        return updateResponse(result);
    }

    /**
     * 更新部门角色信息
     * @param deptRole 部门角色信息
     * @return
     */
    @ApiOperation(value = "更新部门角色信息",notes = "更新部门角色信息")
    @PutMapping("/updateById")
    public ResponseEntity<Response> updateById(@Validated({Update.class}) DeptRole deptRole){
        log.info("更新部门角色信息");

        // 新增一条记录
        boolean result = deptRoleApi.updateById(deptRole);

        return updateResponse(result);
    }

    /**
     * 根据信息获取部门角色信息单个对象
     * @param deptRole 部门角色信息
     * @return
     */
    @ApiOperation(value = "根据信息获取部门角色信息单个对象",notes = "根据信息获取部门角色信息单个对象")
    @GetMapping("/selectOne")
    public ResponseEntity<Response<DeptRole>> selectOne(DeptRole deptRole){
        log.info("根据信息获取部门角色信息单个对象");

        // 根据信息获取部门角色信息列表
        DeptRole entity = deptRoleApi.selectOne(deptRole);

        return responseOk(entity);
    }

    /**
     * 根据信息获取部门角色信息列表
     * @param deptRole 部门角色信息
     * @return
     */
    @ApiOperation(value = "根据信息获取部门角色信息列表",notes = "根据信息获取部门角色信息列表")
    @GetMapping("/select")
    public ResponseEntity<Response<List<DeptRole>>> select(DeptRole deptRole){
        log.info("根据信息获取部门角色信息列表");

        // 根据信息获取部门角色信息列表
        List<DeptRole> list = deptRoleApi.select(deptRole);

        return responseOk(list);
    }

    /**
     * 根据信息获取部门角色分页信息
     * @param deptRole 部门角色信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @ApiOperation(value = "根据信息获取部门角色信息分页信息",notes = "根据信息获取部门角色分页信息")
    @GetMapping("/getPage")
    public ResponseEntity<Response<PageResultVo<DeptRole>>> getPage(DeptRole deptRole, PageParamsVo pageParamsVo){
        log.info("根据信息获取部门角色分页信息");

        // 根据信息获取部门角色分页信息
        PageResultVo<DeptRole> page = deptRoleApi.getPage(deptRole, pageParamsVo);

        return responseOk(page);
    }
}
