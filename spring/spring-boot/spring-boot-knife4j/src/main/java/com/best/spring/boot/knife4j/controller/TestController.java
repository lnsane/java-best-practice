package com.best.spring.boot.knife4j.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {
    @GetMapping
    public Map<String, String> hello() {
        HashMap<String, String> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("hello", "world");
        return objectObjectHashMap;
    }
}
