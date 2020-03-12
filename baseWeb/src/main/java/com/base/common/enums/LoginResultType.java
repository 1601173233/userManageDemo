package com.base.common.enums;

/**
 * 返回码
 *
 * @author huangyujie
 * @version 2019/7/11
 */
public enum LoginResultType {
    /** 成功 */
    SUCCESS(0),
    /** 密码错误 */
    PASSWORD_ERROR(1),
    /** 用户不存在 */
    NOT_EXISTS(2);

    /**
     * 构造方法
     * @param code
     */
    LoginResultType(int code){
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
