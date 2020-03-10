package com.userManager.dict.controller;

import com.userManager.dict.entity.Dict;
import com.userManager.dict.api.DictApi;
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
}
