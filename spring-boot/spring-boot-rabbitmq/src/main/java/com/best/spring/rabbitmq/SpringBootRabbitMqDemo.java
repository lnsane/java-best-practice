package com.best.spring.rabbitmq;

import com.best.spring.rabbitmq.model.Demo1;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.handler.annotation.Payload;

import javax.annotation.PostConstruct;

/**
 * @author 王存露
 */
@SpringBootApplication
public class SpringBootRabbitMqDemo {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRabbitMqDemo.class, args);
    }

    @RabbitListener(queues = "queue2")
    public void rce(@Payload Demo1 demo1) {
        System.out.println(demo1.toString());
    }

}
