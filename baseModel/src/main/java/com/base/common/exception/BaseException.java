package com.base.common.exception;

import lombok.Data;

/**
 * 异常基类
 * @author huangyujie
 * @version 2020/03/15
 */
@Data
public class BaseException extends RuntimeException{
    /** 异常编码 */
    Integer code;

    /**
     * 构造方法
     * @param code
     * @param msg
     * @param casue
     */
    public BaseException(Integer code, String msg, Throwable casue){
        super(msg, casue);
        this.code = code;
    }
}
