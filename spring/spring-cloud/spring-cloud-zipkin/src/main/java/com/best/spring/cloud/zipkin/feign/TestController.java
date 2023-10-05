package com.best.spring.cloud.zipkin.feign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {
    @Autowired
    private Hello2Feign helloFeign;

    @GetMapping("/test")
    public String test() {
        log.info("开始");
        helloFeign.hello();
        log.info("异常");
        return "";
    }
}
