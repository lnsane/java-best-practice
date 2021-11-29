package com.best.spring.rabbitmq;

import com.best.spring.rabbitmq.service.MyPrivete;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 王存露
 */
@SpringBootApplication
public class SpringBootRabbitMqDemo {

    @Autowired
    private MyPrivete myPrivete;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRabbitMqDemo.class, args);
    }

    @RabbitListener(queues = "queue2")
    public void rce(String demo1, Channel channel, Message message) {
        myPrivete.resolve(demo1, channel, message);
    }

}
