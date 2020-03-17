package com.base.common.enums;

import org.springframework.util.StringUtils;

/**
 * 错误信息枚举映射类
 *
 * @author huangyujie
 * @version 2019/7/11
 */
public enum ErrorMsgType {
    /** 服务调用超时 */
    READ_TIME_OUT("Read timed out", "服务调用超时"),
    /** SQL调用异常 */
    SQL_EXCEPTION("SQLSyntaxErrorException", "SQL调用异常");

    /**
     * 构造方法
     * @param keyWord 展示的关键字
     * @param errorMsg 展示的错误信息
     */
    ErrorMsgType(String keyWord, String errorMsg){
        this.keyWord = keyWord;
        this.errorMsg = errorMsg;
    }

    /** 展示的关键字 */
    private String keyWord;

    /** 展示的错误信息 */
    private String errorMsg;

    /**
     * 获取展示的关键字
     */
    public String getKeyWord() {
        return keyWord;
    }

    /**
     * 获取展示的错误信息
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * 获取错误信息
     * @param errorMsg
     */
    public static String getErrorMsg(String errorMsg){
        if(StringUtils.isEmpty(errorMsg)){
            return errorMsg;
        }

        // 如果匹配到关键字，那么就返回对应的错误信息
        for(ErrorMsgType errorMsgType : ErrorMsgType.values()){
            if(errorMsg.indexOf(errorMsgType.getKeyWord()) > -1){
                return errorMsgType.errorMsg;
            }
        }

        return errorMsg;
    }
}
