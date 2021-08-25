package com.best.spring.cloud.openfeign.controller;

import com.best.spring.cloud.openfeign.feign.HelloFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private HelloFeign helloFeign;

    @GetMapping("/test")
    public String test(String name) {
        return helloFeign.sayHello(name);
    }
}
