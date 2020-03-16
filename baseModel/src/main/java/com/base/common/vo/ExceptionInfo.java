package com.base.common.vo;

import lombok.Data;

/**
 * 错误异常类
 * @version 2020/03/15
 * @From https://blog.csdn.net/hnhygkx/article/details/89492031
 */
@Data
public class ExceptionInfo {
    /** 异常时间戳 */
    private String timestamp;

    /** 异常ID */
    private String uuid;

    /** 异常信息 */
    private String serviceName;

    /** 异常码 */
    private String status;

    /** 异常类型 */
    private String exception;

    /** 异常信息 */
    private String message;

    /** 异常代码位置 */
    private String path;
}