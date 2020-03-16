package com.base.common.feign;

import com.base.common.exception.ServiceException;
import com.base.common.util.GsonUtil;
import com.base.common.vo.ExceptionInfo;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Map;

/**
 * 服务调用异常
 */
@Slf4j
@Configuration
public class StashErrorDecoder extends ErrorDecoder.Default implements ErrorDecoder {
 
    @Override
    public Exception decode(String methodKey, Response response) {
        // 自定义错误传递
        if(response.status() == 9999){
            String body = null;
            if (response.body() != null) {
                try {
                    body = Util.toString(response.body().asReader());
                } catch (IOException e) {

                }

                if(body == null){
                    return super.decode(methodKey, response);
                }

                Map map = GsonUtil.fromJson(body, Map.class);

                // 如果存在自定义异常
                if(map.containsKey("exceptionInfo")){
                    Map<String, String> exceptionInfoMap = (Map) map.get("exceptionInfo");

                    ExceptionInfo exceptionInfo = new ExceptionInfo();
                    exceptionInfo.setTimestamp(exceptionInfoMap.get("timestamp"));
                    exceptionInfo.setUuid(exceptionInfoMap.get("uuid"));
                    exceptionInfo.setStatus(exceptionInfoMap.get("status"));
                    exceptionInfo.setException(exceptionInfoMap.get("exception"));
                    exceptionInfo.setServiceName(exceptionInfoMap.get("serviceName"));
                    exceptionInfo.setPath(exceptionInfoMap.get("path"));
                    exceptionInfo.setMessage(exceptionInfoMap.get("message"));

                    ServiceException serviceException = new ServiceException();
                    serviceException.setExceptionInfo(exceptionInfo);
                    return serviceException;
                }else{
                    // 否则进行默认处理
                    return super.decode(methodKey, response);
                }
            }
        }

        return super.decode(methodKey, response);
    }
}