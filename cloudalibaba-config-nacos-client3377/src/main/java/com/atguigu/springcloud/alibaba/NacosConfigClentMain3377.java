package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lihuaiqiang
 * @description
 * @date 2020/10/17 11:06
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigClentMain3377 {

    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClentMain3377.class, args);
    }
}
