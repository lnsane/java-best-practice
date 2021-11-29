package com.best.spring.cloud.lock.zookeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZookeeperLockApp {
    public static void main(String[] args) {
        SpringApplication.run(ZookeeperLockApp.class, args);
    }
}
