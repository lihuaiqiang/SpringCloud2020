package com.atguigu.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * 全局日志过滤器
 * @author lihuaiqiang
 * @description
 * @date 2020/12/7 0:23
 */
@Component
@Slf4j
public class MyLogGatewayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("come in MyLogGatewayFilter：" + new Date());
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if (null == username) {
            log.info("用户名为空，非法用户，o(╥﹏╥)o");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        //第一个过滤器通过了之后，会方形来到后边其他的过滤器再去处理
        return chain.filter(exchange);
    }

    /**
     * 加载过滤器的顺序，值越小优先级越高
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
