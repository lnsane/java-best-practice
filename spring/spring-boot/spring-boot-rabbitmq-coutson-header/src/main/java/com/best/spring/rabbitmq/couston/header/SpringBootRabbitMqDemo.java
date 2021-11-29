package com.best.spring.rabbitmq.couston.header;

import com.best.spring.rabbitmq.couston.header.model.Demo1;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.handler.annotation.Payload;

/**
 * @author 王存露
 */
@SpringBootApplication
public class SpringBootRabbitMqDemo {

    private final String INDEX = "index";
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRabbitMqDemo.class, args);
    }

    @RabbitListener(queues = "queue2", concurrency = "2-5")
    public void rce(@Payload Demo1 demo1,Channel channel, Message message) throws InterruptedException, JsonProcessingException {
        Logger logger = LoggerFactory.getLogger(SpringBootRabbitMqDemo.class);
        logger.info("正在消费");
        System.out.println(demo1.toString());
        logger.info("消费完成");
        MessageProperties messageProperties = message.getMessageProperties();
        Integer header = (Integer) messageProperties.getHeader(INDEX);
        logger.info("queue2 ： {}" ,header);
        if ((Integer) header < 10) {
            messageProperties.setHeader(INDEX,(Integer) header + 1);
            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(demo1);
            Message coustonMessage = new Message(s.getBytes(),messageProperties);
            Thread.sleep(5000);
            rabbitTemplate.convertAndSend("queue1",coustonMessage);
        }
    }

    @RabbitListener(queues = "queue1", concurrency = "2-5")
    public void rce2(@Payload Demo1 demo1, Channel channel, Message message) throws InterruptedException, JsonProcessingException {
        Logger logger = LoggerFactory.getLogger(SpringBootRabbitMqDemo.class);
        logger.info("正在消费");
        System.out.println(demo1.toString());
        logger.info("消费完成");
        MessageProperties messageProperties = message.getMessageProperties();
        Object header = messageProperties.getHeader(INDEX);
        if (header == null) {
            messageProperties.setHeader(INDEX,1);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(demo1);
        Message custom = new Message(s.getBytes(),messageProperties);
        Thread.sleep(5000);
        rabbitTemplate.convertAndSend("queue2",custom);
    }
}
