package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author lihuaiqiang
 * @description
 * @date 2020/9/3 22:28
 *
 * @EnableEurekaServer 注解的作用就是：表明该项目就是 Eureka服务注册中心，由该项目进行服务的管理、配置、登记注册
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class, args);
    }
}
