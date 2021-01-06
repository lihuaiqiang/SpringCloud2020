package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String testA(String name) {
        /*try {
            //暂停800毫秒
            TimeUnit.MILLISECONDS.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        log.info("测试流控效果之排队等待: testA");
        System.out.println("name=" + name);
        return "---testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "--testB";
    }

    /**
     * 测试降级规则：慢调用比例，RT
     *
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
     *
     * @return
     */
    @GetMapping("/testE")
    public String testE() {
        int i = 10 / 0;
        log.info("测试异常比例");
        return "-----TestE";
    }

    /**
     * 测试降级规则：异常数
     *
     * @return
     */
    @GetMapping("/testF")
    public String testF() {
        int i = 10 / 0;
        log.info("测试异常数");
        return "-----TestF";
    }

    /**
     * @SentinelResource 注解属性解释
     * value：资源的唯一名称。
     * blockHandler: 当违反了在Sentinel控制台配置的热点规则有一个兜底的处理方法。
     *
     * @param p1
     * @param p2
     * @return
     */
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "-----------   testHotKey";
    }

    /**
     * 违反热点规则后来进行处理的兜底方法
     *
     * @param p1
     * @param p2
     * @param exception
     * @return
     */
    public String deal_testHotKey(String p1, String p2, BlockException exception) {
        // Sentinel 系统默认的提示：Blocked by Sentinel (flow limiting)
        return "------ deal_testHotKey ";
    }
}
