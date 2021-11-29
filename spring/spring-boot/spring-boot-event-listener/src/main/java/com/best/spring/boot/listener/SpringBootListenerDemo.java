package com.best.spring.boot.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringBootListenerDemo {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootListenerDemo.class, args);
    }
}
