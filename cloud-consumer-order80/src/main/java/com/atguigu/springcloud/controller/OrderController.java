package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author lihuaiqiang
 * @description
 * @date 2020/9/2 22:48
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {

    //private static final String PAYMENT_URL = "http://localhost:8001";
    //通过在 Eureka 上注册过的微服务名称（即服务提供者的名称）调用
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/create")
    public CommonResult create(Payment payment) {
        /**
         * 第一个参数：请求接口的地址
         * 第二个参数：请求接口需要的入参
         * 第三个参数：返回值的Class实例
         */
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/payment/createForEntity")
    public CommonResult create2(Payment payment) {
        /**
         * 第一个参数：请求接口的地址
         * 第二个参数：请求接口需要的入参
         * 第三个参数：返回值的Class实例
         */
        ResponseEntity<CommonResult> postForEntity = restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        if (postForEntity.getStatusCode().is2xxSuccessful()) {
            return postForEntity.getBody();
        } else {
            return new CommonResult(444, "新增失败");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        /**
         * getForObject：返回对象为响应体中数据转换成的对象，基本上可以理解为 JSON
         */
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/payment/getForEntity/{id}")
    public CommonResult getPayment2(@PathVariable("id") Long id) {
        /**
         * 返回对象为ResponseEntity对象，包含了响应中的一些重要信息，比如响应头、响应状态码、响应体等。
         */
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (forEntity.getStatusCode().is2xxSuccessful()) {
            return forEntity.getBody();
        } else {
            return new CommonResult(444, "操作失败");
        }
    }
}
