package com.best.spring.cloud.openfeign.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${spring.application.name}", url = "localhost:${server.port}", path = "/v1")
public interface HelloFeign {
    /**
     * say hello
     *
     * @param name 名字
     * @return hello + 名字
     */
    @GetMapping("/hello")
    String sayHello(@RequestParam(value = "name") String name);
}
