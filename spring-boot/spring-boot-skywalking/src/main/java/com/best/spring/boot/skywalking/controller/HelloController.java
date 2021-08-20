package com.best.spring.boot.skywalking.controller;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王存露
 */
@RestController
public class HelloController {
    Logger logger = new LoggerContext().getLogger(HelloController.class);

    @GetMapping("/test")
    public void test() {
        logger.info("this is test api");
    }
}
