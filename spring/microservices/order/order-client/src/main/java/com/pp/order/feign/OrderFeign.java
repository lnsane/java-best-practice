package com.pp.order.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "order", url = "localhost:8899",  fallback = OrderFail.class)
public interface OrderFeign extends OrderApi {

}
