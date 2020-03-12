package com.base.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * swagger配置类
 * @author huangyujie
 * @version 2019/7/11
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    public Docket createRestApi(){
        List<ResponseMessage> responseMessageList = getResponseMessageList();

        return new Docket(DocumentationType.SWAGGER_2)
        .globalResponseMessage(RequestMethod.GET, responseMessageList)
        .globalResponseMessage(RequestMethod.POST, responseMessageList)
        .globalResponseMessage(RequestMethod.PUT, responseMessageList)
        .globalResponseMessage(RequestMethod.DELETE, responseMessageList)
        .apiInfo(apiInfo())
        .select()
        .paths(PathSelectors.any())
        .build();
    }
    
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
            .title("api文档")
            .build();
    }

    /**
     * 配置全局的错误码注释
     */
    private List<ResponseMessage> getResponseMessageList(){
        List<ResponseMessage> responseMessageList = new ArrayList<>();
        responseMessageList.add(new ResponseMessageBuilder().code(200).message("请求成功").build());
        responseMessageList.add(new ResponseMessageBuilder().code(401).message("未授权").build());
        responseMessageList.add(new ResponseMessageBuilder().code(403).message("禁止访问").build());
        responseMessageList.add(new ResponseMessageBuilder().code(404).message("找不到对应服务").build());
        responseMessageList.add(new ResponseMessageBuilder().code(500).message("服务器出现故障").build());
        return responseMessageList;
    }
}