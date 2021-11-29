package com.best.spring.rabbitmq.couston.header.controller;

import com.best.spring.rabbitmq.couston.header.enums.DemoEnum1;
import com.best.spring.rabbitmq.couston.header.model.Demo1;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王存露
 */
@RestController
@RequestMapping
public class HelloController {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @GetMapping("123123")
    public void hello123123(){
        Demo1 demo1 = new Demo1();
        demo1.setName("123123123");
        demo1.setDemoEnum1(DemoEnum1.MAN);
        rabbitTemplate.convertAndSend("queue1",demo1);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        Demo1 demo1 = new Demo1();
//        demo1.setName("123123123");
//        demo1.setDemoEnum1(DemoEnum1.MAN);
//        rabbitTemplate.convertAndSend("queue1",demo1);
//    }
}
