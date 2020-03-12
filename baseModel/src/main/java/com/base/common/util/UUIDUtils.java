package com.base.common.util;

import java.util.UUID;

/**
 * uuid工具类
 * @author huangyujie
 * @version 2020/03/12
 */
public class UUIDUtils {
    /**
     * 获取uuid
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString();
    }
}
