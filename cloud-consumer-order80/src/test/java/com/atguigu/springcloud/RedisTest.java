//package com.atguigu.springcloud;
//
///**
// * @author lihuaiqiang
// * @description
// * @date 2020/9/14 11:50
// */
//public class RedisTest {
//
//    private static final String key_mutex = "";
//
//    public String get(String key) {
//        //从缓存中读取数据
//        String value = redis.get(key);
//        //缓存中没有数据
//        if (null == value) {
//            //设置3min的超时，防止delete操作失败的情况下下次缓存过期一直不能去数据库中加载查询数据
//            if (redis.setnx(key_mutex, 1, 3 * 60) == 1) {
//                value = db.get(key);
//                redis.set(key, value, expire_secs);
//                redis.delete(key_mutex);
//            } else {
//                //表示同一时刻其他线程已经从数据库中成功读取了数据并回设到了缓存中，这个时候重试读取花奴才能中的数据
//                sleep(100);
//                //重试从缓存中取数据
//                value = redis.get(key);
//            }
//        }
//        return value;
//    }
//}
