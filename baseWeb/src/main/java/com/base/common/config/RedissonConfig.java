package com.base.common.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: 海加尔金鹰
 * @Date: 2019年03月12日  17:47
 * @Description:
 */
@Configuration
public class RedissonConfig {
    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.timeout}")
    private int timeout;

    @Bean
    public RedissonClient getRedisson(){
        Config config = new Config();
        config.useSingleServer()
              .setAddress("redis://" + host + ":" + port)
              .setTimeout(timeout);
        return Redisson.create(config);
    }
}