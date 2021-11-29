package com.best.spring.boot.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * @author 王存露
 */
@SpringBootApplication
@EnableKafka
public class SpringBootKafkaDemo {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootKafkaDemo.class, args);
    }

    @KafkaListener(topics = "topicName",groupId = "123456",concurrency="10")
    public void listenGroupFoo(String message) {
        System.out.println("Received Message in group foo: " + message);
    }
}
