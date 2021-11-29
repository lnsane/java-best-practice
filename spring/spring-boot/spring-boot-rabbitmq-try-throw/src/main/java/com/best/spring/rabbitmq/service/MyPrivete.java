package com.best.spring.rabbitmq.service;

import com.best.spring.rabbitmq.SpringBootRabbitMqDemo;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author lnsane
 */
@Component
public class MyPrivete {
    public void resolve(String demo1, Channel channel, Message message) {
//        long queue2 = channel.basicGet("queue2", false).getEnvelope().getDeliveryTag();
        Logger logger = LoggerFactory.getLogger(SpringBootRabbitMqDemo.class);
        logger.info("正在消费");
        System.out.println(demo1.toString());
        if (1 / 0 == 1) {

        }
        logger.info("消费完成");
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
