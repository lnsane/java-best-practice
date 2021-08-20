package com.best.spring.boot.web.controller;

import cn.hutool.core.thread.ThreadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王存露
 */
@RestController
public class HelloController {
    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public void hello() throws InterruptedException {
        logger.info("-----> hello controller brefore");
        ThreadUtil.safeSleep(1000000000);
        logger.info("-----> hello controller after");
    }
}
