package com.atguigu.springcloud.alibaba.handler;

        import com.alibaba.csp.sentinel.slots.block.BlockException;
        import com.atguigu.springcloud.entities.CommonResult;

/**
 * @author lihuaiqiang
 * @description
 * @date 2021/1/6 16:45
 */
public class CustomerBlockHandler {

    public static CommonResult handleException(BlockException exception){
        return new CommonResult(4444, "按客户自定义的，global handlerException ---- 1");
    }

    public static CommonResult handleException2(BlockException exception){
        return new CommonResult(4444, "按客户自定义的，global handlerException ---- 2");
    }
}
