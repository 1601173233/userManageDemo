package com.userManager.log.controller;

import com.userManager.log.entity.OperationLog;
import com.userManager.log.api.OperationLogApi;
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
 * 操作日志表控制层
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@RequestMapping("${urlHead}/operationLog")
@RestController
@Slf4j
@Api(tags = "操作日志管理")
@ApiResponses({@ApiResponse(code = 500, message = "服务器内部错误")})
public class OperationLogController extends BaseController {
    /**
     * 操作日志管理服务
     */
    @Autowired
    OperationLogApi operationLogApi;

    /**
     * 根据 id 获取操作日志信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据 id 获取操作日志信息",notes = "根据 id 获取操作日志信息")
    @ApiImplicitParam(name="id", value ="id", required = true, dataType = "String", paramType = "query")
    @GetMapping("/getById")
    public ResponseEntity<Response<OperationLog>> getById(String id){
        log.info("根据 id 获取操作日志信息");

        OperationLog result = operationLogApi.getById(id);

        // 根据id获取记录
        return responseOk(result);
    }

    /**
     * 根据 id 删除操作日志信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据 id 删除操作日志信息",notes = "根据 id 删除操作日志信息")
    @ApiImplicitParam(name="id", value ="id", required = true, dataType = "String", paramType = "query")
    @DeleteMapping("/removeById")
    public ResponseEntity<Response> removeById(String id){
        log.info("根据 id 删除操作日志信息");

        // 删除对应的记录
        boolean result = operationLogApi.removeById(id);

        return updateResponse(result);
    }

    /**
     * 新增操作日志信息
     * @param operationLog 操作日志信息
     * @return
     */
    @ApiOperation(value = "新增操作日志信息",notes = "新增操作日志信息")
    @PostMapping("/save")
    public ResponseEntity<Response> save(@Validated({Insert.class}) OperationLog operationLog){
        log.info("新增操作日志信息");

        // 新增一条记录
        boolean result = operationLogApi.save(operationLog);

        return updateResponse(result);
    }

    /**
     * 更新操作日志信息
     * @param operationLog 操作日志信息
     * @return
     */
    @ApiOperation(value = "更新操作日志信息",notes = "更新操作日志信息")
    @PutMapping("/updateById")
    public ResponseEntity<Response> updateById(@Validated({Update.class}) OperationLog operationLog){
        log.info("更新操作日志信息");

        // 新增一条记录
        boolean result = operationLogApi.updateById(operationLog);

        return updateResponse(result);
    }

    /**
     * 根据信息获取操作日志信息单个对象
     * @param operationLog 操作日志信息
     * @return
     */
    @ApiOperation(value = "根据信息获取操作日志信息单个对象",notes = "根据信息获取操作日志信息单个对象")
    @GetMapping("/selectOne")
    public ResponseEntity<Response<OperationLog>> selectOne(OperationLog operationLog){
        log.info("根据信息获取操作日志信息单个对象");

        // 根据信息获取操作日志信息列表
        OperationLog entity = operationLogApi.selectOne(operationLog);

        return responseOk(entity);
    }

    /**
     * 根据信息获取操作日志信息列表
     * @param operationLog 操作日志信息
     * @return
     */
    @ApiOperation(value = "根据信息获取操作日志信息列表",notes = "根据信息获取操作日志信息列表")
    @GetMapping("/select")
    public ResponseEntity<Response<List<OperationLog>>> select(OperationLog operationLog){
        log.info("根据信息获取操作日志信息列表");

        // 根据信息获取操作日志信息列表
        List<OperationLog> list = operationLogApi.select(operationLog);

        return responseOk(list);
    }

    /**
     * 根据信息获取操作日志分页信息
     * @param operationLog 操作日志信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @ApiOperation(value = "根据信息获取操作日志信息分页信息",notes = "根据信息获取操作日志分页信息")
    @GetMapping("/getPage")
    public ResponseEntity<Response<PageResultVo<OperationLog>>> getPage(OperationLog operationLog, PageParamsVo pageParamsVo){
        log.info("根据信息获取操作日志分页信息");

        // 根据信息获取操作日志分页信息
        PageResultVo<OperationLog> page = operationLogApi.getPage(operationLog, pageParamsVo);

        return responseOk(page);
    }
}
