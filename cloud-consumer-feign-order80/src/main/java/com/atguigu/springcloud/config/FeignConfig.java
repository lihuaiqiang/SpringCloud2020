package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lihuaiqiang
 * @description
 * @date 2020/10/20 11:46
 */
@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level getFeignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
