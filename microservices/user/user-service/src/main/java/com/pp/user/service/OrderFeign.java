package com.pp.user.service;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "order", url = "localhost:8899",  fallbackFactory = OrderFail.class)
public interface OrderFeign extends OrderApi {

}
