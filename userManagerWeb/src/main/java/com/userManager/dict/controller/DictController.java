package com.userManager.dict.controller;

import com.base.common.controller.BaseController;
import com.base.common.validType.Insert;
import com.base.common.validType.Update;
import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.base.common.vo.Response;
import com.base.common.vo.TreeVo;
import com.userManager.dict.api.DictApi;
import com.userManager.dict.entity.Dict;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 字典表控制层
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@RequestMapping("${urlHead}/dict")
@RestController
@Slf4j
@Api(tags = "字典管理")
@ApiResponses({@ApiResponse(code = 500, message = "服务器内部错误")})
public class DictController extends BaseController {
    /**
     * 字典管理服务
     */
    @Autowired
    DictApi dictApi;

    /**
     * 根据 id 获取字典信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据 id 获取字典信息",notes = "根据 id 获取字典信息")
    @ApiImplicitParam(name="id", value ="id", required = true, dataType = "String", paramType = "query")
    @GetMapping("/getById")
    public ResponseEntity<Response<Dict>> getById(String id){
        log.info("根据 id 获取字典信息");

        Dict result = dictApi.getById(id);

        // 根据id获取记录
        return responseOk(result);
    }

    /**
     * 根据 id 删除字典信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据 id 删除字典信息",notes = "根据 id 删除字典信息")
    @ApiImplicitParam(name="id", value ="id", required = true, dataType = "String", paramType = "query")
    @DeleteMapping("/removeById")
    public ResponseEntity<Response> removeById(String id){
        log.info("根据 id 删除字典信息");

        // 删除对应的记录
        boolean result = dictApi.removeById(id);

        return updateResponse(result);
    }

    /**
     * 新增字典信息
     * @param dict 字典信息
     * @return
     */
    @ApiOperation(value = "新增字典信息",notes = "新增字典信息")
    @PostMapping("/save")
    public ResponseEntity<Response> save(@Validated({Insert.class}) Dict dict){
        log.info("新增字典信息");

        // 新增一条记录
        boolean result = dictApi.save(dict);

        return updateResponse(result);
    }

    /**
     * 更新字典信息
     * @param dict 字典信息
     * @return
     */
    @ApiOperation(value = "更新字典信息",notes = "更新字典信息")
    @PutMapping("/updateById")
    public ResponseEntity<Response> updateById(@Validated({Update.class}) Dict dict){
        log.info("更新字典信息");

        // 新增一条记录
        boolean result = dictApi.updateById(dict);

        return updateResponse(result);
    }

    /**
     * 根据信息获取字典信息单个对象
     * @param dict 字典信息
     * @return
     */
    @ApiOperation(value = "根据信息获取字典信息单个对象",notes = "根据信息获取字典信息单个对象")
    @GetMapping("/selectOne")
    public ResponseEntity<Response<Dict>> selectOne(Dict dict){
        log.info("根据信息获取字典信息单个对象");

        // 根据信息获取字典信息列表
        Dict entity = dictApi.selectOne(dict);

        return responseOk(entity);
    }

    /**
     * 根据信息获取字典信息列表
     * @param dict 字典信息
     * @return
     */
    @ApiOperation(value = "根据信息获取字典信息列表",notes = "根据信息获取字典信息列表")
    @GetMapping("/select")
    public ResponseEntity<Response<List<Dict>>> select(Dict dict){
        log.info("根据信息获取字典信息列表");

        // 根据信息获取字典信息列表
        List<Dict> list = dictApi.select(dict);

        return responseOk(list);
    }

    /**
     * 根据信息获取字典分页信息
     * @param dict 字典信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @ApiOperation(value = "根据信息获取字典信息分页信息",notes = "根据信息获取字典分页信息")
    @GetMapping("/getPage")
    public ResponseEntity<Response<PageResultVo<Dict>>> getPage(Dict dict, PageParamsVo pageParamsVo){
        log.info("根据信息获取字典分页信息");

        // 根据信息获取字典分页信息
        PageResultVo<Dict> page = dictApi.getPage(dict, pageParamsVo);

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
        log.info("节点移动到指定的父节点：节点{},移动到{}的最后", id, newParentId);
        boolean result = dictApi.move(id, newParentId, nextNodeId);
        return updateResponse(result);
    }

    /**
     * 根据字典类型获取字典树
     * @param type 字典类型
     * @return
     */
    @ApiOperation(value = "根据字典类型获取字典树")
    @GetMapping("/getTreeByDictType")
    @ApiImplicitParam(name="type", value ="字典类型", required = true, dataType = "String", paramType = "query")
    public ResponseEntity<Response<TreeVo<Dict>>> getTreeByDictType(String type){
        log.info("根据字典类型获取字典树");
        TreeVo<Dict> treeVo = dictApi.getTreeByDictType(type);
        return responseOk(treeVo);
    }
}
