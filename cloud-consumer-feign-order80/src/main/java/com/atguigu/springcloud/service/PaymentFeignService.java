package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lihuaiqiang
 * @description
 * @date 2020/10/19 21:26
 *
 * @FeignClient 这个注解中的name和value属性，作用是一样的，指定要调用的服务的名称。
 *              path就类似在Controller类上加@RequestMapping注解一样，配置一个公共的路径。
 */
@Component
@FeignClient(name = "cloud-payment-service", path = "/payment")
public interface PaymentFeignService {

    @GetMapping("/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/feign/timeout")
    String paymentFeignTimeOutTest();
}
