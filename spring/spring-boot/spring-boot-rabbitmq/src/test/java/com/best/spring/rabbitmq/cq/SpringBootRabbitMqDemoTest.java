package com.best.spring.rabbitmq.cq;

import com.best.spring.rabbitmq.cq.enums.DemoEnum1;
import com.best.spring.rabbitmq.cq.model.Demo1;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootRabbitMqDemoTest {

    @Autowired
    public AmqpTemplate amqpTemplate;

    @Test
    public void test() {
        Demo1 demoEnum1 = new Demo1();
        demoEnum1.setName("1");
        demoEnum1.setDemoEnum1(DemoEnum1.MAN);
        amqpTemplate.convertAndSend("exp1", null, demoEnum1);
    }
}