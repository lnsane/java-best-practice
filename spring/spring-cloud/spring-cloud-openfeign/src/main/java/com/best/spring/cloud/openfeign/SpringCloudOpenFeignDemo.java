package com.best.spring.cloud.openfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.best.spring.cloud.openfeign.feign", "com.best.spring.cloud.openfeign.lnheritance"})
public class SpringCloudOpenFeignDemo {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudOpenFeignDemo.class, args);
    }
}
