package com.atguigu.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lihuaiqiang
 * @description
 * @date 2020/12/16 18:25
 */
@RestController
//@RequestMapping("/sentinel")
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        /*try {
            //暂停800毫秒
            TimeUnit.MILLISECONDS.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        log.info("测试流控效果之排队等待: testA");
        return "---testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "--testB";
    }
}
