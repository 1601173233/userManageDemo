package com.userManager.user.enums;

/**
 * 登录接口返回值
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

    /** 返回编码 */
    private int code;

    /**
     * 返回编码
     * @return
     */
    public int getCode(){
        return code;
    }
}
