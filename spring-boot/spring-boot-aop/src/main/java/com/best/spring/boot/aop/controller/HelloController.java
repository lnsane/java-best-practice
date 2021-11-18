package com.best.spring.boot.aop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lnsane
 */
@RestController
public class HelloController {
    private final static Logger log = LoggerFactory.getLogger(HelloController.class);

    @GetMapping
    public void hello() {
        log.info("hello");
        if (1 / 0 == 9) {

        }
    }
}
