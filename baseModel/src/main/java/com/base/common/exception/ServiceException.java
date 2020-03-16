package com.base.common.exception;

import com.base.common.vo.ExceptionInfo;
import lombok.Data;

/**
 * 服务异常信息
 * @author huangyujie
 * @version 2020/03/15
 */
@Data
public class ServiceException extends RuntimeException{
    /** 服务异常信息 */
    ExceptionInfo exceptionInfo;
}
