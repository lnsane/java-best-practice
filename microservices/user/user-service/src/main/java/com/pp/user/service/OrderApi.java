package com.pp.user.service;

import com.bao.common.core.bean.BaseResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;

public interface OrderApi {
    @GetMapping("/order")
    BaseResponse<OrderDTO> getOrder();
}
