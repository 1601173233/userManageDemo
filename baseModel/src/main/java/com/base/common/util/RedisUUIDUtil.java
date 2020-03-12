package com.base.common.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author czx
 * @title: RedisUUID
 * @projectName ms
 * @description: TODO 配置唯一ID保存到redis
 * @date 2019/7/2614:33
 */
@Component
public class RedisUUIDUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    // 过期时间
    private final static long expiration = 1000 * 60 * 5;

    // 过期前1分钟
    private final static long lastTime = 1000 * 60;

    /**
     * 创建uuid键
     * @param key
     * @return
     */
    public String create(String key){
        if(StringUtils.isBlank(key)){
            return null;
        }
        String secretKey;
        if(redisTemplate.hasKey(key)){
            if(redisTemplate.boundHashOps(key).getExpire() < lastTime){
                redisTemplate.opsForValue().set(key, MD5Util.getMD5(UUIDUtils.getUUID()), expiration, TimeUnit.SECONDS);
            }
            secretKey = (String) redisTemplate.opsForValue().get(key);
        }else{
            secretKey = MD5Util.getMD5(UUIDUtils.getUUID());
            redisTemplate.opsForValue().set(key, secretKey, expiration, TimeUnit.SECONDS);
        }
        return secretKey;
    }

    /**
     * 获取对应Key的Uuid
     * @param key
     * @return
     */
    public Object get(String key){
        return redisTemplate.opsForValue().get(key);
    }
}