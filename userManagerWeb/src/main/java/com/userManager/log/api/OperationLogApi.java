package com.userManager.log.api;

import com.userManager.log.entity.OperationLog;
import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import java.util.List;

/**
 * 操作日志对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@FeignClient(name = "${serviceName.gateway}/${serviceName.userManage}")
public interface OperationLogApi{
    /**
     * 根据 id 获取操作日志信息
     * @param id
     * @return
     */
    @RequestLine(value = "GET /innerApi/log/operationLogApi/getById")
    OperationLog getById(@Param("id") String id);

    /**
     * 根据 id 删除操作日志信息
     * @param id
     * @return
     */
    @RequestLine(value = "DELETE /innerApi/log/operationLogApi/removeById")
    boolean removeById(@Param("id") String id);

    /**
     * 新增操作日志信息
     * @param operationLog 操作日志信息
     * @return
     */
    @RequestLine(value = "PUT /innerApi/log/operationLogApi/save")
    boolean save(@Param("operationLog") OperationLog operationLog);

    /**
     * 更新操作日志信息
     * @param operationLog 操作日志信息
     * @return
     */
    @RequestLine(value = "POST /innerApi/log/operationLogApi/updateById")
    boolean updateById(@Param("operationLog") OperationLog operationLog);

    /**
     * 根据信息获取操作日志信息单个对象
     * @param operationLog 操作日志信息
     * @return
     */
    @RequestLine(value = "GET /innerApi/log/operationLogApi/selectOne")
    OperationLog selectOne(@Param("operationLog") OperationLog operationLog);

    /**
     * 根据信息获取操作日志信息列表
     * @param operationLog 操作日志信息
     * @return
     */
    @RequestLine(value = "GET /innerApi/log/operationLogApi/select")
    List<OperationLog> select(@Param("operationLog") OperationLog operationLog);

    /**
     * 根据信息获取操作日志分页信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @RequestLine(value = "GET /innerApi/log/operationLogApi/getPage")
    PageResultVo<OperationLog> getPage(@Param("operationLog") OperationLog operationLog, @Param("pageParamsVo") PageParamsVo pageParamsVo);
}