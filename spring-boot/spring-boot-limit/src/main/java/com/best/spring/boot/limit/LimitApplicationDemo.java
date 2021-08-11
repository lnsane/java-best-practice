package com.best.spring.boot.limit;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.json.JSONUtil;
import com.best.spring.boot.limit.controller.DemoController;
import com.github.onblog.core.limiter.RateLimiter;
import com.github.onblog.core.observer.RateLimiterObserver;
import com.github.onblog.snowjeanspringbootstarter.annotation.entity.Limiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author 王存露
 */
@SpringBootApplication
public class LimitApplicationDemo {

    private final LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
    Logger logger = LoggerFactory.getLogger(LimitApplicationDemo.class);
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Resource
    private RabbitListenerEndpointRegistry rabbitListenerEndpointRegistry;
    @Autowired
    private DemoController demoController;


    public static void main(String[] args) {
        SpringApplication.run(LimitApplicationDemo.class, args);
    }

    @RabbitListener(id = "myQ", queues = "queue2", containerFactory = "prefetchTenRabbitListenerContainerFactory")
    @Limiter(value = "limiter", fallback = "sayFallback")
    public void hello(String msg, Message message) {
        logger.info("正在消费 ： {}", msg);
//        ThreadUtil.sleep(10, TimeUnit.SECONDS);
        this.pick(msg, message);
    }


    public void pick(String msg, Message oldMsg) {
        logger.info("已被消费 ： {}", msg);
//        demoController.pick(msg);
    }

    public void sayFallback(String msg, Message oldMsg) throws InterruptedException {
        logger.info("error : {}", msg);
//        MessageListenerContainer listener = rabbitListenerEndpointRegistry.getListenerContainer("myQ");
//        listener.stop();
//        rabbitTemplate.convertAndSend("queue2", msg, message -> {
//            if (oldMsg.getMessageProperties()
//                      .getPriority() == 100) {
//                message.getMessageProperties()
//                       .setPriority(oldMsg.getMessageProperties()
//                                          .getPriority());
//            } else {
//                message.getMessageProperties()
//                       .setPriority(oldMsg.getMessageProperties()
//                                          .getPriority() + 1);
//            }
//            return message;
//        });
//        listener.start();
        RateLimiter rateLimiter = RateLimiterObserver.getMap()
                                                     .get("limiter");
        while (!rateLimiter.tryAcquire()) {

        }
        DemoController.AA aa1 = JSONUtil.toBean(msg, DemoController.AA.class);
        rabbitTemplate.convertAndSend("queue2", aa1, message -> {
            if (oldMsg.getMessageProperties()
                      .getPriority() == 100) {
                message.getMessageProperties()
                       .setPriority(oldMsg.getMessageProperties()
                                          .getPriority());
            } else {
                message.getMessageProperties()
                       .setPriority(oldMsg.getMessageProperties()
                                          .getPriority() + 1);
            }
            logger.info("优先级 ： {}", message.getMessageProperties()
                                           .getPriority());
            return message;
        });
        ThreadUtil.sleep(1, TimeUnit.SECONDS);
//        while (queue.size() > 0) {
//            if (rateLimiter.tryAcquire()) {
//                if (queue.size() > 0) {
//                    rabbitTemplate.convertAndSend("queue2", queue.poll());
//                }
//            }
//        }
    }

}
