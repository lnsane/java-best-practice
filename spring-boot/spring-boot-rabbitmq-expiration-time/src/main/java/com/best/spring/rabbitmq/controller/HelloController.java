package com.best.spring.rabbitmq.controller;

import com.best.spring.rabbitmq.GoodsConst;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lnsane
 */
@RestController
@RequestMapping
public class HelloController {
    private AmqpTemplate amqpTemplate;

    public HelloController(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @GetMapping
    public void hello() {
        MessageProperties props = new MessageProperties();
        props.setExpiration("6000");
        Message message2 = new Message("1".getBytes(), props);
        amqpTemplate.convertAndSend(GoodsConst.SYNC_AMAZON_GOODS_DELAY_EXCHANGE_NAME, GoodsConst.SYNC_AMAZON_GOODS_DELAY_QUEUE_ROUTING_KEY, message2);
    }
}
