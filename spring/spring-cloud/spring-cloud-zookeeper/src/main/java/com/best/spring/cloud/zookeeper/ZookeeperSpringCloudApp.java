package com.best.spring.cloud.zookeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZookeeperSpringCloudApp {
    public static void main(String[] args) {
        SpringApplication.run(ZookeeperSpringCloudApp.class, args);
    }
}
