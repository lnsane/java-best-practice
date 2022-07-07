package com.pp.seata.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "spring-boot-nacos-config-order", path = "/test22")
public interface HelloFeign {
    /**
     * say hello
     *
     * @return hello + 名字
     */
    @GetMapping("/isExist")
    void isExist();
}
