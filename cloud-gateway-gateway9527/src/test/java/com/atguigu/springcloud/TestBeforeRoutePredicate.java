package com.atguigu.springcloud;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * 使用 Java8 中的时间工具类生成时间串
 * @author lihuaiqiang
 * @description
 * @date 2020/12/6 21:00
 */
public class TestBeforeRoutePredicate {

    public static void main(String[] args) {
        //默认时区
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println("当前时间：" + now);

        //使用指定时区获取当前时间
        ZonedDateTime newYorkTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("纽约时间：" + newYorkTime);
    }
}
