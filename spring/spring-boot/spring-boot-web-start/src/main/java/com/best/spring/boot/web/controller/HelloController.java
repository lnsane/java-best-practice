package com.best.spring.boot.web.controller;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.http.HttpUtil;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author 王存露
 */
@RestController
public class HelloController {
    Logger logger = LoggerFactory.getLogger(HelloController.class);

    HashMap<String,String> hashMap = new HashMap<>();
    @GetMapping("/hello")
    public void hello(HttpSession httpSession) throws InterruptedException {

    }

    public static void main(String[] args) {
        ThreadUtil.concurrencyTest(105, () -> {
            HttpUtil.createGet("http://localhost:8039/demo")
                    .execute();
        });
    }
    private void checker(@NonNull String str) {
        logger.info(str);
    }
}
