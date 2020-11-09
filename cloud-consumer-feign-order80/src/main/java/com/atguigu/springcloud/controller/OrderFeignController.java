package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lihuaiqiang
 * @description
 * @date 2020/10/19 21:08
 */
@RestController
@Slf4j
@RequestMapping("/openfeign/consumer")
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        CommonResult paymentById = paymentFeignService.getPaymentById(id);
        return paymentById;
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeOutTest(){
        return paymentFeignService.paymentFeignTimeOutTest();
    }
}
