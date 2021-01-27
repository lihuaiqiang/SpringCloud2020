package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author lihuaiqiang
 * @description
 * @date 2020/9/7 10:10
 */
@RestController
@RequestMapping
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("数据的插入!!!");

        if(result > 0){
            return new CommonResult(200, "插入成功，server.port：" + serverPort, result);
        } else {
            return new CommonResult(400, "插入失败", null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id, HttpServletRequest request){
        Enumeration<String> headerNames = request.getHeaderNames();
        System.out.println("kkk===" + headerNames);
        String platform = request.getHeader("platform");
        System.out.println(platform);

        Payment payment = paymentService.getPaymentById(id);
        log.info("8002提供服务");

        if(payment != null){
            return new CommonResult(200, "查询成功，server.port：" + serverPort, payment);
        } else {
            return new CommonResult(400, "查询失败", null);
        }
    }
}
