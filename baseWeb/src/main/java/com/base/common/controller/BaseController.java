package com.base.common.controller;

import com.base.common.enums.ErrorMsgType;
import com.base.common.enums.HttpCode;
import com.base.common.exception.ServiceException;
import com.base.common.util.ExceptionUtil;
import com.base.common.util.UUIDUtils;
import com.base.common.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 控制器基类,用于封装返回值和异常
 * @author huangyujie
 * @version 2019/7/11
 */
@Slf4j
public class BaseController {
    /**
     * 返回结果
     * @param t
     * @return
     */
    protected <T>ResponseEntity<Response<T>> responseOk(T t) {
        Response<T> response = new Response<>(HttpCode.OK);
        response.setData(t);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * 返回结果(更新)
     * @return
     */
    protected ResponseEntity<Response> updateResponse(int result) {
        /** 更新成功 */
        if(result > 1){
            return updateResponse(true);
        }else{
            return updateResponse(false);
        }
    }

    /**
     * 返回结果(更新)
     * @return
     */
    protected ResponseEntity<Response> updateResponse(boolean success) {
        Response response;

        // 如果更新到数据
        if(success) {
            response = new Response<>(HttpCode.OK);
        }else{
            // 否则提示校验失败
            response = new Response<>(HttpCode.VALID_ERROR);
        }

        return new ResponseEntity(response, HttpStatus.OK);
    }

    /**
     * 异常统一处理
     * @param request
     * @param ex
     */
    @ExceptionHandler
    public ResponseEntity<Response> excptionHandler(HttpServletRequest request, Exception ex){
        Response response = new Response(HttpCode.SYS_ERROR);
        Map<String, String> errorMsg = new HashMap<>();

        if(ex instanceof ServiceException){
            ServiceException serviceException = ((ServiceException) ex);
            log.error("来自服务的异常：\r\n{}" ,serviceException.getExceptionInfo());

            // 如果有返回自定义的返回码
            if(StringUtils.isNotEmpty(serviceException.getExceptionInfo().getStatus())){
                response.setCode(Integer.parseInt(serviceException.getExceptionInfo().getStatus()));
            }

            errorMsg.put("message", serviceException.getExceptionInfo().getMessage());
            errorMsg.put("errorUUID", serviceException.getExceptionInfo().getUuid());

            response.setData(errorMsg);
        }else{
            String uuid = UUIDUtils.getUUID();

            // 异常信息输出到日志
            log.error("服务器出现错误：\r\nuuid:{}\r\ntimestamp:{}\r\n  excetionMsg:{}\r\n  excetion:\r\n{}",
                    uuid,
                    System.currentTimeMillis(),
                    ex.getMessage(),
                    ExceptionUtil.getStackTraceString(ex));

            errorMsg.put("message", ex.getMessage());
            errorMsg.put("errorUUID", uuid);

            response.setData(errorMsg);
        }

        // 如果是系统错误
        if(response.getCode() == 500){
            // 对错误信息进行映射处理
            errorMsg.put("message", ErrorMsgType.getErrorMsg(errorMsg.get("message")));
        }

        return new ResponseEntity(response, HttpStatus.OK);
    }
}
