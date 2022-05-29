package com.pp.order.feign;

import com.bao.common.core.bean.BaseResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.pp.order.bean.OrderDTO;

public class OrderFail implements OrderFeign{

    @HystrixCommand(fallbackMethod = "timeOutError",
            commandProperties =
                    //规定 5 秒钟以内就不报错，正常运行，超过 5 秒就报错，调用指定的方法
                    {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")})
    @Override
    public BaseResponse<OrderDTO> getOrder() {
        OrderDTO orderDTO = new OrderDTO();
        return BaseResponse.fail(orderDTO);
    }

    public BaseResponse<OrderDTO> timeOutError(){
        OrderDTO orderDTO = new OrderDTO();
        return BaseResponse.fail(orderDTO);
    }
}
