package com.best.spring.boot.mq.aop.t.aespt;

import cn.hutool.json.JSONUtil;
import com.best.spring.boot.mq.aop.t.DownloadConst;
import com.best.spring.boot.mq.aop.t.model.Order;
import com.best.spring.boot.mq.aop.t.service.OrderService;
import com.rabbitmq.client.Channel;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author lnsane
 */
@Aspect
@Component
public class DownloadAop {
    private final static Logger log = LoggerFactory.getLogger(DownloadAop.class);
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private OrderService orderService;

    @Pointcut("execution(public * com.best.spring.boot.mq.aop.t.service.Azom.download(..))")
    public void controller() {
    }

    @Before(value = "controller()")
    public void before() {
        log.info("before");
    }

    @After(value = "controller()")
    public void after(JoinPoint joinPoint) {
        log.info("after");
    }

    @AfterReturning(value = "controller()")
    public void afterReturning(JoinPoint joinPoint) {
        log.info("afterReturning");
        Object[] args = joinPoint.getArgs();
        Channel channel = (Channel) args[1];
        Message message = (Message) args[2];
//        if (order.getState().equals(1) || order.getState().equals(2))

    }

    @AfterThrowing(value = "controller()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        log.info("afterThrowing");
        Object[] args = joinPoint.getArgs();
        Channel channel = (Channel) args[1];
        Message message = (Message) args[2];
        Order arg = (Order) args[0];
        Order byId = orderService.getById(arg.getId());
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            MessageProperties props = new MessageProperties();
            props.setDelay(message.getMessageProperties().getReceivedDelay() * 2);
            Message message2 = new Message(JSONUtil.toJsonStr(byId).getBytes(), props);
            amqpTemplate.convertAndSend(DownloadConst.AMAZON_GOODS_DOWNLOAD_DELAY_EXCHANGE,
                    DownloadConst.AMAZON_GOODS_DOWNLOAD_DELAY_ROUTING_KEY, message2);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    @Around(value = "controller()")
    public Object pointcut(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("pointcut before");
        Object proceed = joinPoint.proceed();
        log.info("pointcut after");
        return proceed;
    }
}
