package com.userManager.dict.controller;

import com.userManager.dict.entity.DictType;
import com.userManager.dict.api.DictTypeApi;
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
 * 字典类型表表控制层
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@RequestMapping("${urlHead}/dictType")
@RestController
@Slf4j
@Api(tags = "字典类型表管理")
@ApiResponses({@ApiResponse(code = 500, message = "服务器内部错误")})
public class DictTypeController extends BaseController {
    /**
     * 字典类型表管理服务
     */
    @Autowired
    DictTypeApi dictTypeApi;

    /**
     * 根据 id 获取字典类型表信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据 id 获取字典类型表信息",notes = "根据 id 获取字典类型表信息")
    @ApiImplicitParam(name="id", value ="id", required = true, dataType = "String", paramType = "query")
    @GetMapping("/getById")
    public ResponseEntity<Response<DictType>> getById(String id){
        log.info("根据 id 获取字典类型表信息");

        DictType result = dictTypeApi.getById(id);

        // 根据id获取记录
        return responseOk(result);
    }

    /**
     * 根据 id 删除字典类型表信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据 id 删除字典类型表信息",notes = "根据 id 删除字典类型表信息")
    @ApiImplicitParam(name="id", value ="id", required = true, dataType = "String", paramType = "query")
    @DeleteMapping("/removeById")
    public ResponseEntity<Response> removeById(String id){
        log.info("根据 id 删除字典类型表信息");

        // 删除对应的记录
        boolean result = dictTypeApi.removeById(id);

        return updateResponse(result);
    }

    /**
     * 新增字典类型表信息
     * @param dictType 字典类型表信息
     * @return
     */
    @ApiOperation(value = "新增字典类型表信息",notes = "新增字典类型表信息")
    @PostMapping("/save")
    public ResponseEntity<Response> save(@Validated({Insert.class}) DictType dictType){
        log.info("新增字典类型表信息");

        // 新增一条记录
        boolean result = dictTypeApi.save(dictType);

        return updateResponse(result);
    }

    /**
     * 更新字典类型表信息
     * @param dictType 字典类型表信息
     * @return
     */
    @ApiOperation(value = "更新字典类型表信息",notes = "更新字典类型表信息")
    @PutMapping("/updateById")
    public ResponseEntity<Response> updateById(@Validated({Update.class}) DictType dictType){
        log.info("更新字典类型表信息");

        // 新增一条记录
        boolean result = dictTypeApi.updateById(dictType);

        return updateResponse(result);
    }

    /**
     * 根据信息获取字典类型表信息单个对象
     * @param dictType 字典类型表信息
     * @return
     */
    @ApiOperation(value = "根据信息获取字典类型表信息单个对象",notes = "根据信息获取字典类型表信息单个对象")
    @GetMapping("/selectOne")
    public ResponseEntity<Response<DictType>> selectOne(DictType dictType){
        log.info("根据信息获取字典类型表信息单个对象");

        // 根据信息获取字典类型表信息列表
        DictType entity = dictTypeApi.selectOne(dictType);

        return responseOk(entity);
    }

    /**
     * 根据信息获取字典类型表信息列表
     * @param dictType 字典类型表信息
     * @return
     */
    @ApiOperation(value = "根据信息获取字典类型表信息列表",notes = "根据信息获取字典类型表信息列表")
    @GetMapping("/select")
    public ResponseEntity<Response<List<DictType>>> select(DictType dictType){
        log.info("根据信息获取字典类型表信息列表");

        // 根据信息获取字典类型表信息列表
        List<DictType> list = dictTypeApi.select(dictType);

        return responseOk(list);
    }

    /**
     * 根据信息获取字典类型表分页信息
     * @param dictType 字典类型表信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @ApiOperation(value = "根据信息获取字典类型表信息分页信息",notes = "根据信息获取字典类型表分页信息")
    @GetMapping("/getPage")
    public ResponseEntity<Response<PageResultVo<DictType>>> getPage(DictType dictType, PageParamsVo pageParamsVo){
        log.info("根据信息获取字典类型表分页信息");

        // 根据信息获取字典类型表分页信息
        PageResultVo<DictType> page = dictTypeApi.getPage(dictType, pageParamsVo);

        return responseOk(page);
    }
}
