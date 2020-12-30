package com.atguigu.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

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

    /**
     * 测试降级规则：慢调用比例，RT
     * @return
     */
    @GetMapping("/testD")
    public String testD() {
        try {
            //延时1秒钟
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(" testD 测试 RT");
        return "------TestD";
    }

    /**
     * 测试降级规则：异常比例
     * @return
     */
    @GetMapping("/testE")
    public String testE(){
        int i = 10/0;
        log.info("测试异常比例");
        return "-----TestE";
    }

    /**
     * 测试降级规则：异常数
     * @return
     */
    @GetMapping("/testF")
    public String testF(){
        int i = 10/0;
        log.info("测试异常数");
        return "-----TestF";
    }
}
