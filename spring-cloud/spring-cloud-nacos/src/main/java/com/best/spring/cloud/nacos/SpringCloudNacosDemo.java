package com.best.spring.cloud.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 王存露
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudNacosDemo {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudNacosDemo.class, args);
    }
}
