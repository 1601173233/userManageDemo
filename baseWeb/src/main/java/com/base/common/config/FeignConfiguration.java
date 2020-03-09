package com.base.common.config;

import com.base.common.feign.FeignSpringFormEncoder;
import feign.Contract;
import feign.codec.Encoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * fegin配置类
 * @Author Gu Yuxing
 * @Create 2019-02-12 18:45
 * source https://blog.csdn.net/qq_34523427/article/details/88863800
 **/
@Configuration
public class FeignConfiguration {
    /**
     * 启用Fegin自定义注解 如@RequestLine @Param
     * @return
     */
    @Bean
    public Contract feignContract(){
       return new Contract.Default();
   }


    /**
     * feign 实现多pojo传输与MultipartFile上传 编码器，需配合开启feign自带注解使用
     */
    @Bean
    public Encoder feignSpringFormEncoder(){
        return new FeignSpringFormEncoder();
    }
}