package com.best.spring.rabbitmq.aop;

import com.best.spring.rabbitmq.GoodsConst;
import com.rabbitmq.client.Channel;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author lnsane
 */
@Aspect
@Component
@Order(1)
public class CoustomApest {
    private final static Logger log = LoggerFactory.getLogger(CoustomApest.class);
    @Autowired
    private AmqpTemplate amqpTemplate;
    private RabbitTemplate rabbitTemplate;

    @Pointcut("execution(public * com.best.spring.rabbitmq.service.*.*(..))")
    public void controller() {
    }


    @AfterThrowing(throwing = "e", pointcut = "controller()")
    public void tryThrow(JoinPoint joinPoint, RuntimeException e) {
        System.out.println(joinPoint);
        Object[] args = joinPoint.getArgs();
        String msg = (String) args[0];
        Channel channel = (Channel) args[1];
        Message message = (Message) args[2];
        try {
            MessageProperties props = new MessageProperties();
            props.setExpiration("30000");
            Message message2 = new Message(msg.getBytes(), props);
            amqpTemplate.convertAndSend(GoodsConst.SYNC_AMAZON_GOODS_DELAY_EXCHANGE_NAME, GoodsConst.SYNC_AMAZON_GOODS_DELAY_QUEUE_ROUTING_KEY, message2);
            log.info("end");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println(e);
    }

    @Before("execution(public * com.best.spring.rabbitmq.service.*.*(..))")
    public void before(JoinPoint poin) {
        System.out.println(poin);
    }

    @AfterReturning(pointcut = "controller()",
            returning = "result")
    public void returnResult(JoinPoint point, Object result) {
        System.out.println(point);
    }

    @Around("controller()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(joinPoint);
        Object[] args = joinPoint.getArgs();
        return joinPoint.proceed();
    }
}
