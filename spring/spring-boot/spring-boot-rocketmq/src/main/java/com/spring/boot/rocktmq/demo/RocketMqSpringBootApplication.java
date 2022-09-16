package com.spring.boot.rocktmq.demo;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author CunLu Wang
 * @since 2022/9/16
 */
@SpringBootApplication

public class RocketMqSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(RocketMqSpringBootApplication.class,args);
    }
}
