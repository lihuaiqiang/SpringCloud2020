package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lihuaiqiang
 * @description  通用封装类
 * @date 2020/9/3 10:08
 *
 * @NoArgsConstructor  空参构造器
 * @AllArgsConstructor 全参构造器
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {

    /**
     * 响应状态码
     */
    private Integer code;
    /**
     * 响应信息
     */
    private String message;
    /**
     * 具体的业务实体
     */
    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
