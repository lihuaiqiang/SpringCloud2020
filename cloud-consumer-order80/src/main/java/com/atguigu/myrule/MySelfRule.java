package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lihuaiqiang
 * @description
 * @date 2020/10/9 0:15
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        //定义为随机的规则
        return new RandomRule();
    }
}
