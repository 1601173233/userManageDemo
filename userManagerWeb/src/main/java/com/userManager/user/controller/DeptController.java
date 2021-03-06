package com.userManager.user.controller;

import com.userManager.user.entity.Dept;
import com.userManager.user.api.DeptApi;
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
 * 部门表控制层
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@RequestMapping("${urlHead}/dept")
@RestController
@Slf4j
@Api(tags = "部门管理")
@ApiResponses({@ApiResponse(code = 500, message = "服务器内部错误")})
public class DeptController extends BaseController {
    /**
     * 部门管理服务
     */
    @Autowired
    DeptApi deptApi;

    /**
     * 根据 id 获取部门信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据 id 获取部门信息",notes = "根据 id 获取部门信息")
    @ApiImplicitParam(name="id", value ="id", required = true, dataType = "String", paramType = "query")
    @GetMapping("/getById")
    public ResponseEntity<Response<Dept>> getById(String id){
        log.info("根据 id 获取部门信息");

        Dept result = deptApi.getById(id);

        // 根据id获取记录
        return responseOk(result);
    }

    /**
     * 根据 id 删除部门信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据 id 删除部门信息",notes = "根据 id 删除部门信息")
    @ApiImplicitParam(name="id", value ="id", required = true, dataType = "String", paramType = "query")
    @DeleteMapping("/removeById")
    public ResponseEntity<Response> removeById(String id){
        log.info("根据 id 删除部门信息");

        // 删除对应的记录
        boolean result = deptApi.removeById(id);

        return updateResponse(result);
    }

    /**
     * 新增部门信息
     * @param dept 部门信息
     * @return
     */
    @ApiOperation(value = "新增部门信息",notes = "新增部门信息")
    @PostMapping("/save")
    public ResponseEntity<Response> save(@Validated({Insert.class}) Dept dept){
        log.info("新增部门信息");

        // 新增一条记录
        boolean result = deptApi.save(dept);

        return updateResponse(result);
    }

    /**
     * 更新部门信息
     * @param dept 部门信息
     * @return
     */
    @ApiOperation(value = "更新部门信息",notes = "更新部门信息")
    @PutMapping("/updateById")
    public ResponseEntity<Response> updateById(@Validated({Update.class}) Dept dept){
        log.info("更新部门信息");

        // 新增一条记录
        boolean result = deptApi.updateById(dept);

        return updateResponse(result);
    }

    /**
     * 根据信息获取部门信息单个对象
     * @param dept 部门信息
     * @return
     */
    @ApiOperation(value = "根据信息获取部门信息单个对象",notes = "根据信息获取部门信息单个对象")
    @GetMapping("/selectOne")
    public ResponseEntity<Response<Dept>> selectOne(Dept dept){
        log.info("根据信息获取部门信息单个对象");

        // 根据信息获取部门信息列表
        Dept entity = deptApi.selectOne(dept);

        return responseOk(entity);
    }

    /**
     * 根据信息获取部门信息列表
     * @param dept 部门信息
     * @return
     */
    @ApiOperation(value = "根据信息获取部门信息列表",notes = "根据信息获取部门信息列表")
    @GetMapping("/select")
    public ResponseEntity<Response<List<Dept>>> select(Dept dept){
        log.info("根据信息获取部门信息列表");

        // 根据信息获取部门信息列表
        List<Dept> list = deptApi.select(dept);

        return responseOk(list);
    }

    /**
     * 根据信息获取部门分页信息
     * @param dept 部门信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @ApiOperation(value = "根据信息获取部门信息分页信息",notes = "根据信息获取部门分页信息")
    @GetMapping("/getPage")
    public ResponseEntity<Response<PageResultVo<Dept>>> getPage(Dept dept, PageParamsVo pageParamsVo){
        log.info("根据信息获取部门分页信息");

        // 根据信息获取部门分页信息
        PageResultVo<Dept> page = deptApi.getPage(dept, pageParamsVo);

        return responseOk(page);
    }

    /**
     * 节点移动到指定的父节点
     * @param id 移动的节点ID
     * @param newParentId 父节点ID
     * @param parentType 父节点类型:1.区域，2.部门
     * @param nextNodeId 下一个节点的Id，如果为空说明是插入
     */
    @ApiOperation(value = "节点移动到指定的父节点")
    @PutMapping("/move")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id", value ="移动的节点ID", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name="newParentId", value ="父节点ID", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name="parentType", value ="父节点类型:1.区域，2.部门", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name="nextNodeId", value ="移动后当前节点后一个节点的ID，空表示当前节点为最后一个节点（不能移动到区域的前面）", dataType = "int", paramType = "query")
    })
    public ResponseEntity<Response> move(Integer id, Integer newParentId, Integer parentType, Integer nextNodeId){
        log.info("节点移动到指定的父节点：节点{},移动到{}的最后", id, newParentId);
        boolean result = deptApi.move(id, newParentId, parentType ,nextNodeId);
        return updateResponse(result);
    }

}
