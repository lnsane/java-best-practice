package com.best.spring.rabbitmq.cq;

import com.best.spring.rabbitmq.cq.model.Demo1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.handler.annotation.Payload;

/**
 * @author 王存露
 */
@SpringBootApplication
public class SpringBootRabbitMqDemo {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRabbitMqDemo.class, args);
    }

    @RabbitListener(queues = "queue2", concurrency = "2-5")
    public void rce(@Payload Demo1 demo1) throws InterruptedException {
        Logger logger = LoggerFactory.getLogger(SpringBootRabbitMqDemo.class);
        logger.info("正在消费");
        Thread.sleep(1000000000);
        System.out.println(demo1.toString());
        logger.info("消费完成");
    }

}
