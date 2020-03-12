package com.userManager;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 启动类
 */
@EnableFeignClients(basePackages={"com.userManager", "com.base"})
@EnableDiscoveryClient
@SpringBootApplication
@Slf4j
@EnableSwagger2
@EnableScheduling
@ComponentScan(basePackages={"com.userManager","com.base"})
public class UserManagerWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagerWebApplication.class, args);
	}

}
