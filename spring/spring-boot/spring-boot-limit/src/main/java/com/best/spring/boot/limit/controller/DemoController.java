package com.best.spring.boot.limit.controller;

import cn.hutool.core.util.IdUtil;
import com.github.onblog.snowjeanspringbootstarter.annotation.entity.Limiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王存露
 */
@RestController
public class DemoController {
    Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping(value = "/")
//    @Limiter(value = "limiter", fallback = "sayFallback")
    public void hello() {
//        String a = IdUtil.fastUUID();
        AA a = new AA();
        a.setAa(IdUtil.fastUUID());
        logger.info("消息 ： {}", a.getAa());

        rabbitTemplate.convertAndSend("queue2", a, message -> {
            message.getMessageProperties()
                   .setPriority(0);
            return message;
        });
//        this.pick("1");
    }

    public class AA {
        private String aa;

        public String getAa() {
            return aa;
        }

        public void setAa(String aa) {
            this.aa = aa;
        }
    }

    public void sayFallback(String msg) {
        logger.info("限流");
    }

    @Limiter(value = "limiter", fallback = "sayFallback")
    public void pick(String msg) {
        logger.info("已被消费 ： {}", msg);
    }
}
