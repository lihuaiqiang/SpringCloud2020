package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义网关的filter
 *
 * @author lihuaiqiang
 * @description
 * @date 2020/12/6 17:02
 */
@Configuration
public class GatewayConfig {

    /**
     * 配置了一个ID为“path_route_atguigu”的路由规则。
     * 当访问地址 http://localhost:9527/guonei 时会自动转发到地址：http://baidu.com/guonei
     *
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_atguigu", r -> r.path("/guonei").uri("http://news.baidu.com")).build();
        return routes.build();
    }

    @Bean
    public RouteLocator customerRouteLocator2(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_atguigu2", r -> r.path("/guoji").uri("http://news.baidu.com")).build();
        return routes.build();
    }
}
