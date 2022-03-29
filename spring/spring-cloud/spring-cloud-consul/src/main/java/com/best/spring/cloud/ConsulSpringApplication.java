package com.best.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsulSpringApplication.class, args);
    }
}
