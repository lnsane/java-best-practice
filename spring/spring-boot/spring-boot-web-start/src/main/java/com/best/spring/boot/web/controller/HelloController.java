package com.best.spring.boot.web.controller;

import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author 王存露
 */
@RestController
public class HelloController {
    Logger logger = LoggerFactory.getLogger(HelloController.class);

    HashMap<String,String> hashMap = new HashMap<>();
    @GetMapping("/hello")
    public void hello(HttpSession httpSession) throws InterruptedException {
//        String id = httpSession.getId();
//        logger.info(id);
//        logger.info("-----> hello controller brefore");
//        logger.info("-----> hello controller after");
//        this.checker(null);
        while (true) {
            hashMap.put(UUID.randomUUID().toString(),UUID.randomUUID().toString());
        }
    }

    private void checker(@NonNull String str) {
        logger.info(str);
    }
}
