package com.base.common.enums;

/**
 * 异常编码
 * @author huangyujie
 * @version 2020/03/15
 */
public enum ExceptionCodeType {
    /** 未授权 */
    NO_AUTH(401),
    /** 禁止 */
    REJECT(403),
    /** 未找到 */
    NO_FOUND(404),
    /** 校验失败 */
    VALID_ERROR(10000),
    /** 系统错误 */
    SYS_ERROR(500);

    /**
     * 构造方法
     * @param code
     */
    ExceptionCodeType(Integer code){
        this.code = code;
    }

    /** 返回编码 */
    private Integer code;

    /**
     * 返回编码
     * @return
     */
    public Integer getCode(){
        return code;
    }
}
