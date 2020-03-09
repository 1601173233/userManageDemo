package com.base.common.util;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Gson工具类
 * @author huangyujie
 * @version 2020/03/08
 */
@Component
public class GsonUtil {
    /** gons */
    private static Gson gson;

    @Bean
    public Gson gson(){
        if(gson == null) {
            gson = new Gson();;
        }

        return gson;
    }

    /**
     * 对象转json
     * @param o 对象
     * @return
     */
    public static String toJson(Object o){
        return gson.toJson(o);
    }

    /**
     * json转对象
     * @param jsonStr json字符串
     * @param c 类型
     * @return
     */
    public static <T> T fromJson(String jsonStr, Class<T> c){
            return gson.fromJson(jsonStr, c);
    }
}
