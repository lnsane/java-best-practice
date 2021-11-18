package com.best.spring.cloud.openfeign.controller;

import com.best.spring.cloud.openfeign.lnheritance.Hello2Feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private Hello2Feign helloFeign;

    @GetMapping("/test")
    public String test() {
        helloFeign.hello();
        return "";
    }
}
