package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author lihuaiqiang
 * @description
 * @date 2020/9/2 10:25
 */
@RestController
@RequestMapping
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;

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
        log.info("8001提供服务");

        if(payment != null){
            return new CommonResult(200, "查询成功，server.port：" + serverPort, payment);
        } else {
            return new CommonResult(400, "查询失败", null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for(String service : services){
            System.out.println("service：" + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getInstanceId()+"\t" +instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return discoveryClient;
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeOutTest(){
        try {
            Thread.sleep(2000);
//            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e){
            e.printStackTrace();
        }
        return serverPort;
    }
}
