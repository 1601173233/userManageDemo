package com.base.common.exception;

import com.base.common.enums.ExceptionCodeType;
import com.base.common.util.ExceptionUtil;
import com.base.common.util.UUIDUtils;
import com.base.common.vo.ExceptionInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 异常统一处理
 */
@ControllerAdvice
@Slf4j
public class GlobalController {
    @Value("${eureka.instance.instance-id}")
    private String instanceId;

    /**
     * 异常统一处理类
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody//使之返回json格式数据
    public Map<String, Object> exceptionHandler(HttpServletResponse response, Exception e){
        Map<String, Object> map = new HashMap<>();
        response.setStatus(9999);

        // 如果是服务异常，直接把异常返回出去
        if(e instanceof ServiceException){
            map.put("exceptionInfo", ((ServiceException) e).getExceptionInfo());
            return map;
        }

        ExceptionInfo exceptionInfo = new ExceptionInfo();
        exceptionInfo.setTimestamp(System.currentTimeMillis() + "");
        exceptionInfo.setUuid(UUIDUtils.getUUID());
        exceptionInfo.setMessage(e.getMessage());
        exceptionInfo.setPath(e.getStackTrace()[0].getClassName() + "." + e.getStackTrace()[0].getMethodName() + ":" + e.getStackTrace()[0].getLineNumber());
        exceptionInfo.setException(e.getClass().getName());
        exceptionInfo.setServiceName(instanceId); // 实例名称

        // 如果是自定义的异常
        if(e instanceof BaseException){
            exceptionInfo.setStatus(((BaseException) e).getCode().toString());
        }else{
            // 否则为系统异常
            exceptionInfo.setStatus(ExceptionCodeType.SYS_ERROR.getCode().toString());
        }

        // 异常信息输出到日志
        log.error("\r\nExceptionMsg:\r\n  uuid:{}\r\n  timestamp:{}\r\n  excetion:\r\n{}",
                exceptionInfo.getUuid(),
                exceptionInfo.getTimestamp(),
                ExceptionUtil.getStackTraceString(e));

        map.put("exceptionInfo", exceptionInfo);
        return map;
    }
}