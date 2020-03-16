package com.base.common.util;

import com.base.common.enums.ExceptionCodeType;
import com.base.common.exception.BaseException;

/**
 * 异常工具类
 * @author huangyujie
 * @version 2020/03/15
 */
public class ExceptionUtil {
    /**
     * 未授权
     * @return
     */
    public static void noAuth(String msg) throws BaseException {
        noAuth(msg, null);
    }

    /**
     * 未授权
     * @return
     */
    public static void noAuth(String msg, Throwable cause) throws BaseException {
        throw new BaseException(ExceptionCodeType.NO_AUTH.getCode(), msg, cause);
    }

    /**
     * 禁止
     * @return
     */
    public static void reject(String msg) throws BaseException {
        noAuth(msg, null);
    }

    /**
     * 禁止
     * @return
     */
    public static void reject(String msg, Throwable cause) throws BaseException {
        throw new BaseException(ExceptionCodeType.REJECT.getCode(), msg, cause);
    }

    /**
     * 未找到
     * @return
     */
    public static void noFound(String msg) throws BaseException {
        noFound(msg, null);
    }

    /**
     * 未找到
     * @return
     */
    public static void noFound(String msg, Throwable cause) throws BaseException {
        throw new BaseException(ExceptionCodeType.NO_FOUND.getCode(), msg, cause);
    }

    /**
     * 校验失败
     * @return
     */
    public static void validError(String msg) throws BaseException {
        validError(msg, null);
    }

    /**
     * 校验失败
     * @return
     */
    public static void validError(String msg, Throwable cause) throws BaseException {
        throw new BaseException(ExceptionCodeType.VALID_ERROR.getCode(), msg, cause);
    }

    /**
     * 系统错误
     * @return
     */
    public static void sysError(String msg) throws BaseException {
        sysError(msg, null);
    }

    /**
     * 系统错误
     * @return
     */
    public static void sysError(String msg, Throwable cause) throws BaseException {
        throw new BaseException(ExceptionCodeType.SYS_ERROR.getCode(), msg, cause);
    }

    /**
     * 打印异常堆栈信息
     */
    public static String getStackTraceString(Throwable ex){
        StackTraceElement[] traceElements = ex.getStackTrace();

        StringBuilder traceBuilder = new StringBuilder();

        if (traceElements != null && traceElements.length > 0) {
            for (StackTraceElement traceElement : traceElements) {
                traceBuilder.append("    ");
                traceBuilder.append(traceElement.toString());
                traceBuilder.append("\n");
            }
        }

        return traceBuilder.toString();
    }
}
