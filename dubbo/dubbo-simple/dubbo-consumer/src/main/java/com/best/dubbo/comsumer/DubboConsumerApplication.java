package com.best.dubbo.comsumer;

import com.best.dubbo.service.HelloDubboService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
public class DubboConsumerApplication {
    @DubboReference(version = "${demo.service.version}")
    private HelloDubboService helloDubboService;

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class, args);
    }


    @GetMapping(value = "/")
    public String sayHello() {
        return helloDubboService.sayHello(null);
    }

}
