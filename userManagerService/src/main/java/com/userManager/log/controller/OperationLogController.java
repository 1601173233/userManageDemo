package com.userManager.log.controller;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.userManager.log.entity.OperationLog;
import com.userManager.log.service.OperationLogService;
import com.userManager.log.api.OperationLogApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * 操作日志表服务控制层
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@RestController
@Slf4j
public class OperationLogController implements OperationLogApi {
    /**
     * 操作日志管理服务
     */
    @Autowired
    OperationLogService operationLogService;

    @Override
    public OperationLog getById(String id){
        log.info("根据 id 获取操作日志信息");

        OperationLog result = operationLogService.getById(id);

        // 根据id获取记录
        return result;
    }

    @Override
    public boolean removeById(String id){
        log.info("根据 id 删除操作日志信息");

        // 删除对应的记录
        boolean result = operationLogService.removeById(id);

        return result;
    }

    @Override
    public boolean save(OperationLog operationLog){
        log.info("新增操作日志信息");

        // 新增一条记录
        boolean result = operationLogService.save(operationLog);

        return result;
    }

    @Override
    public boolean updateById(OperationLog operationLog){
        log.info("更新操作日志信息");

        // 新增一条记录
        boolean result = operationLogService.updateById(operationLog);

        return result;
    }

    @Override
    public OperationLog selectOne(OperationLog operationLog){
        log.info("根据信息获取操作日志信息单个对象");

        // 根据信息获取操作日志信息列表
        OperationLog entity = operationLogService.selectOne(operationLog);

        return entity;
    }

    @Override
    public List<OperationLog> select(OperationLog operationLog){
        log.info("根据信息获取操作日志信息列表");

        // 根据信息获取操作日志信息列表
        List<OperationLog> list = operationLogService.select(operationLog);

        return list;
    }

    @Override
    public PageResultVo<OperationLog> getPage(OperationLog operationLog, PageParamsVo pageParamsVo){
        log.info("根据信息获取操作日志分页信息");

        // 根据信息获取操作日志分页信息
        PageResultVo<OperationLog> page = operationLogService.getPage(operationLog, pageParamsVo);

        return page;
    }
}
