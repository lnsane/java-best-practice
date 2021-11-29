package com.best.spring.boot.resolve.controller.method.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lnsane
 */
@RestController
public class HelloController {

    private final Log log =  LogFactory.getLog(getClass());

    @GetMapping
    public void hello(User user) {
        log.info(user.toString());
    }
}
