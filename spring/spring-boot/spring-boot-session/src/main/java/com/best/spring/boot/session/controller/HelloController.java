package com.best.spring.boot.session.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.concurrent.TimeUnit;

/**
 * @author 王存露
 */
@RestController
@RequestMapping
public class HelloController {
    private final static Logger log = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping
    public void hello(HttpSession httpSession) {
        String id = httpSession.getId();
        log.info("hello session :  {}", id);
    }

    @GetMapping(value = "send")
    private void send(){
        redisTemplate.opsForValue().set("wangcunlu","123123123",10L, TimeUnit.SECONDS);
    }

    @GetMapping(value = "delete/{str}")
    public void delete(@PathVariable(value = "str") String str,HttpSession httpSession) {
        log.info("delete session :  {}", str);
    }
}
