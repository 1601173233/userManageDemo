package com.userManager;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 启动类
 */
@EnableEurekaServer
@SpringBootApplication
@Slf4j
@EnableSwagger2
@EnableScheduling
@MapperScan("com.userManager.*.mapper")
@ComponentScan(basePackages={"com.userManager","com.base"})
public class UserManagerServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagerServerApplication.class, args);
	}

}
