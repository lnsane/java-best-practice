package com.best.spring.rabbitmq.aop;

import com.rabbitmq.client.Channel;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.amqp.core.Message;
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
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println(e);
    }

    @Around("controller()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(joinPoint);
        Object[] args = joinPoint.getArgs();
        return joinPoint.proceed();
    }
}
