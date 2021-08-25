package com.best.spring.cloud.openfeign.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1")
public class OpenFeignController {
    @GetMapping(value = "/hello")
    public String hello(@RequestParam(value = "name") String name) {
        return "hello " + name;
    }
}
