package com.base.common.enums;

/**
 * 返回码
 *
 * @author huangyujie
 * @version 2019/7/11
 */
public enum HttpCode {
    /** 成功 */
    OK(200),
    /** 未授权 */
    NO_AUTH(401),
    /** 禁止 */
    REJECT(403),
    /** 未找到 */
    NO_FOUND(404),
    /** 校验失败 */
    VALID_ERROR(10000),
    /** 系统错误 */
    SYS_ERROR(500),;

    /**
     * 构造方法
     * @param code
     */
    HttpCode(int code){
        this.code = code;
    }

    /** 返回的错误码 */
    private int code;

    /**
     * 返回错误码
     * @return
     */
    public int getCode(){
        return code;
    }
}
