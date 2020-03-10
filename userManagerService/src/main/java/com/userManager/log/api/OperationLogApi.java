package com.userManager.log.api;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.userManager.log.entity.OperationLog;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 操作日志对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
public interface OperationLogApi{
    /**
     * 根据 id 获取操作日志信息
     * @param id
     * @return
     */
    @GetMapping(value = "/innerApi/log/operationLogApi/getById")
    OperationLog getById(String id);

    /**
     * 根据 id 删除操作日志信息
     * @param id
     * @return
     */
    @DeleteMapping(value = "/innerApi/log/operationLogApi/removeById")
    boolean removeById(String id);

    /**
     * 新增操作日志信息
     * @param operationLog 操作日志信息
     * @return
     */
    @PutMapping(value = "/innerApi/log/operationLogApi/save")
    boolean save(@RequestPart("operationLog") OperationLog operationLog);

    /**
     * 更新操作日志信息
     * @param operationLog 操作日志信息
     * @return
     */
    @PostMapping(value = "/innerApi/log/operationLogApi/updateById")
    boolean updateById(@RequestPart("operationLog") OperationLog operationLog);

    /**
     * 根据信息获取操作日志信息单个对象
     * @param operationLog 操作日志信息
     * @return
     */
    @GetMapping(value = "/innerApi/log/operationLogApi/selectOne")
    OperationLog selectOne(@RequestPart("operationLog") OperationLog operationLog);

    /**
     * 根据信息获取操作日志信息列表
     * @param operationLog 操作日志信息
     * @return
     */
    @GetMapping(value = "/innerApi/log/operationLogApi/select")
    List<OperationLog> select(@RequestPart("operationLog") OperationLog operationLog);

    /**
     * 根据信息获取操作日志分页信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @GetMapping(value = "/innerApi/log/operationLogApi/getPage")
    PageResultVo<OperationLog> getPage(@RequestPart("operationLog") OperationLog operationLog,
                                            @RequestPart("pageParamsVo") PageParamsVo pageParamsVo);
}