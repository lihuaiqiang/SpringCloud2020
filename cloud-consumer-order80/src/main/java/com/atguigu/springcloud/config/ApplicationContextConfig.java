package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lihuaiqiang
 * @description
 * @date 2020/9/2 23:07
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * 使用 @LoadBalanced 注解赋予 RestTemplate 负载均衡的能力。
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate()   {
        return new RestTemplate();
    }
}
