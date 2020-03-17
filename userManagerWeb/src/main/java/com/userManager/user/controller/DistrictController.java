package com.userManager.user.controller;

import com.base.common.controller.BaseController;
import com.base.common.validType.Insert;
import com.base.common.validType.Update;
import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.base.common.vo.Response;
import com.base.common.vo.TreeVo;
import com.userManager.user.api.DistrictApi;
import com.userManager.user.entity.District;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 区域管理表控制层
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@RequestMapping("${urlHead}/district")
@RestController
@Slf4j
@Api(tags = "区域管理管理")
@ApiResponses({@ApiResponse(code = 500, message = "服务器内部错误")})
public class DistrictController extends BaseController {
    /**
     * 区域管理管理服务
     */
    @Autowired
    DistrictApi districtApi;

    /**
     * 根据 id 获取区域管理信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据 id 获取区域管理信息",notes = "根据 id 获取区域管理信息")
    @ApiImplicitParam(name="id", value ="id", required = true, dataType = "String", paramType = "query")
    @GetMapping("/getById")
    public ResponseEntity<Response<District>> getById(String id){
        log.info("根据 id 获取区域管理信息");

        District result = districtApi.getById(id);

        // 根据id获取记录
        return responseOk(result);
    }

    /**
     * 根据 id 删除区域管理信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据 id 删除区域管理信息",notes = "根据 id 删除区域管理信息")
    @ApiImplicitParam(name="id", value ="id", required = true, dataType = "String", paramType = "query")
    @DeleteMapping("/removeById")
    public ResponseEntity<Response> removeById(String id){
        log.info("根据 id 删除区域管理信息");

        // 删除对应的记录
        boolean result = districtApi.removeById(id);

        return updateResponse(result);
    }

    /**
     * 新增区域管理信息
     * @param district 区域管理信息
     * @return
     */
    @ApiOperation(value = "新增区域管理信息",notes = "新增区域管理信息")
    @PostMapping("/save")
    public ResponseEntity<Response> save(@Validated({Insert.class}) District district){
        log.info("新增区域管理信息");

        // 新增一条记录
        boolean result = districtApi.save(district);

        return updateResponse(result);
    }

    /**
     * 更新区域管理信息
     * @param district 区域管理信息
     * @return
     */
    @ApiOperation(value = "更新区域管理信息",notes = "更新区域管理信息")
    @PutMapping("/updateById")
    public ResponseEntity<Response> updateById(@Validated({Update.class}) District district){
        log.info("更新区域管理信息");

        // 新增一条记录
        boolean result = districtApi.updateById(district);

        return updateResponse(result);
    }

    /**
     * 根据信息获取区域管理信息单个对象
     * @param district 区域管理信息
     * @return
     */
    @ApiOperation(value = "根据信息获取区域管理信息单个对象",notes = "根据信息获取区域管理信息单个对象")
    @GetMapping("/selectOne")
    public ResponseEntity<Response<District>> selectOne(District district){
        log.info("根据信息获取区域管理信息单个对象");

        // 根据信息获取区域管理信息列表
        District entity = districtApi.selectOne(district);

        return responseOk(entity);
    }

    /**
     * 根据信息获取区域管理信息列表
     * @param district 区域管理信息
     * @return
     */
    @ApiOperation(value = "根据信息获取区域管理信息列表",notes = "根据信息获取区域管理信息列表")
    @GetMapping("/select")
    public ResponseEntity<Response<List<District>>> select(District district){
        log.info("根据信息获取区域管理信息列表");

        // 根据信息获取区域管理信息列表
        List<District> list = districtApi.select(district);

        return responseOk(list);
    }

    /**
     * 根据信息获取区域管理分页信息
     * @param district 区域管理信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @ApiOperation(value = "根据信息获取区域管理信息分页信息",notes = "根据信息获取区域管理分页信息")
    @GetMapping("/getPage")
    public ResponseEntity<Response<PageResultVo<District>>> getPage(District district, PageParamsVo pageParamsVo){
        log.info("根据信息获取区域管理分页信息");

        // 根据信息获取区域管理分页信息
        PageResultVo<District> page = districtApi.getPage(district, pageParamsVo);

        return responseOk(page);
    }

    /**
     * 节点移动到指定的父节点
     * @param id 移动的节点ID
     * @param newParentId 父节点ID
     */
    @ApiOperation(value = "节点移动到指定的父节点")
    @PutMapping("/move")
    @ApiImplicitParams({
        @ApiImplicitParam(name="id", value ="移动的节点ID", required = true, dataType = "int", paramType = "query"),
        @ApiImplicitParam(name="newParentId", value ="父节点ID", required = true, dataType = "int", paramType = "query"),
        @ApiImplicitParam(name="nextNodeId", value ="移动后当前节点后一个节点的ID，空表示当前节点为最后一个节点", dataType = "int", paramType = "query")
    })
    public ResponseEntity<Response> move(Integer id, Integer newParentId, Integer nextNodeId){
        log.info("根据信息获取区域管理分页信息：节点{},移动到{}的最后", id, newParentId);
        boolean result = districtApi.move(id, newParentId, nextNodeId);
        return updateResponse(result);
    }

    /**
     * 根据信息获取区域树
     * @return
     */
    @ApiOperation(value = "根据信息获取区域树")
    @GetMapping("/getTree")
    public ResponseEntity<Response<TreeVo<String>>> getTree(){
        log.info("根据信息获取区域树");
        TreeVo<String> treeVo = districtApi.getTree();
        return responseOk(treeVo);
    }

    /**
     * 根据信息获取自定子节点下的区域树
     * @return
     */
    @ApiOperation(value = "根据信息获取自定子节点下的区域树")
    @GetMapping("/getTreeByParentCode")
    @ApiImplicitParam(name="parentCode", value ="父节点编码", required = true, dataType = "String", paramType = "query")
    public ResponseEntity<Response<TreeVo<String>>> getTreeByParentCode(String parentCode){
        log.info("根据信息获取自定子节点下的区域树");
        TreeVo<String> treeVo = districtApi.getTreeByParentCode(parentCode);
        return responseOk(treeVo);
    }

    /**
     * 根据信息获取区域部门树
     * @return
     */
    @ApiOperation(value = "根据信息获取区域部门树")
    @GetMapping("/getTreeWithDept")
    public ResponseEntity<Response<TreeVo<String>>> getTreeWithDept(){
        log.info("根据信息获取区域部门树");
        TreeVo<String> treeVo = districtApi.getTreeWithDept();
        return responseOk(treeVo);
    }

    /**
     * 根据信息获取自定子节点下的区域部门树
     * @return
     */
    @ApiOperation(value = "根据信息获取自定子节点下的区域部门树")
    @GetMapping("/getTreeWithDeptByParentCode")
    @ApiImplicitParam(name="parentCode", value ="父节点编码", required = true, dataType = "String", paramType = "query")
    public ResponseEntity<Response<TreeVo<String>>> getTreeWithDeptByParentCode(String parentCode){
        log.info("根据信息获取自定子节点下的区域部门树");
        TreeVo<String> treeVo = districtApi.getTreeWithDeptByParentCode(parentCode);
        return responseOk(treeVo);
    }
}
