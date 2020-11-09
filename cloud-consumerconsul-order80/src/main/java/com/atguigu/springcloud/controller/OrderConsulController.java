package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author lihuaiqiang
 * @description
 * @date 2020/9/29 22:15
 */
@RestController
@Slf4j
public class OrderConsulController {

    /**
     * 服务提供者的服务实例名称
     */
    public static final String INVOKE_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String paymentInfo(){
        /**
         * 第一个参数：请求接口的地址
         * 第二个参数：返回值Class实例
         */
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        return result;
    }
}
