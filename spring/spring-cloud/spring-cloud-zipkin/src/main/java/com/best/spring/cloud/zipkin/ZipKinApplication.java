package com.best.spring.cloud.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author CunLu Wang
 * @since 2023/7/6
 */
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.best.spring.cloud.zipkin.feign"})
public class ZipKinApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZipKinApplication.class,args);
    }
}
