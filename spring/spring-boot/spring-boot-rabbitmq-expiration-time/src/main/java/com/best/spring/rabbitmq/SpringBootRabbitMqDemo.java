package com.best.spring.rabbitmq;

import com.best.spring.rabbitmq.service.MyPrivete;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author 王存露
 */
@SpringBootApplication
public class SpringBootRabbitMqDemo {

    private final static Logger log = LoggerFactory.getLogger(SpringBootRabbitMqDemo.class);
    @Value("${server.port}")
    private String prot;
    @Autowired
    private MyPrivete myPrivete;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRabbitMqDemo.class, args);
    }

    @RabbitListener(queues = GoodsConst.SYNC_AMAZON_GOODS_DEAD_QUEUE_NAME)
    public void rce(String demo1, Channel channel, Message message) {
        log.info("start");
        myPrivete.resolve(demo1, channel, message);
    }

}
