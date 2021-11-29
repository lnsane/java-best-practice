package com.best.spring.boot.sync.event.trancation.controller;

import com.best.spring.boot.sync.event.trancation.service.MyBuisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final static Logger log = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    private MyBuisService myBuisService;

    @GetMapping("/hello")
    public void test() {
        myBuisService.save();
        log.info("hello 完成");
        log.info("hello 完成");
        log.info("hello 完成");
    }
}
