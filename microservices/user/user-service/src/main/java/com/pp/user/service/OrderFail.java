package com.pp.user.service;

import com.bao.common.core.bean.BaseResponse;
import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class OrderFail implements FallbackFactory<OrderFeign>{


    @Override
    public OrderFeign create(Throwable throwable) {


        return new OrderFeign() {
            @Override
            public BaseResponse<OrderDTO> getOrder() {
                return null;
            }
        };
    }
}
