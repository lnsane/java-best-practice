package com.best.spring.boot.dapr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CunLu Wang
 * @since 2022/7/27
 */
@RestController
public class HelloController {
    @GetMapping("hello")
    public Hello hello(){
        Hello hello = new Hello();
        hello.setHello("hello");
        hello.setWorld("world");
        return hello;
    }
}
