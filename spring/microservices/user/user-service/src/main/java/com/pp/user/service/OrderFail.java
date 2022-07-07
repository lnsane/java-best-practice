package com.pp.user.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class OrderFail implements FallbackFactory<OrderFeign>{


    @Override
    public OrderFeign create(Throwable throwable) {


        return () -> null;
    }
}
