package com.best.spring.boot.mq.aop.t.aespt;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.json.JSONUtil;
import com.best.spring.boot.mq.aop.t.GoodsConst;
import com.best.spring.boot.mq.aop.t.model.Order;
import com.best.spring.boot.mq.aop.t.service.OrderService;
import com.rabbitmq.client.Channel;
import lombok.Data;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author lnsane
 */
@Aspect
@Component
@Data
public class Glaobl {
    private final static Logger log = LoggerFactory.getLogger(Glaobl.class);
    private final static String key = "Puting1212";
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private OrderService orderService;
    @Autowired
    private RedissonClient redissonClient;

    @Pointcut("execution(public * com.best.spring.boot.mq.aop.t.service.Azom.put(..))")
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
            amqpTemplate.convertAndSend(GoodsConst.SYNC_AMAZON_GOODS_DELAY_EXCHANGE_NAME,
                    GoodsConst.SYNC_AMAZON_GOODS_DELAY_QUEUE_ROUTING_KEY, message2);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    @Around(value = "controller()")
    public Object pointcut(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("pointcut before");
        String methodName = ThreadUtil.getStackTrace()[2].getMethodName();
        System.out.println(methodName);

        RLock fairLock = redissonClient.getFairLock(key);
        Object o = null;
        try {
            fairLock.lock(120, TimeUnit.SECONDS);
            o = joinPoint.proceed();
        } catch (Exception e) {
            log.error("asdasd");
        } finally {
            fairLock.unlock();
        }
        log.info("pointcut after");
        return o;
    }
}
