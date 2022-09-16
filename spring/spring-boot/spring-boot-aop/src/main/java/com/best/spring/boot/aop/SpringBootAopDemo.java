package com.best.spring.boot.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author lnsane
 */
@SpringBootApplication
@Slf4j
@EnableScheduling
public class SpringBootAopDemo {
    private static int t = 0;
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAopDemo.class, args);
    }

    @Scheduled(cron = "*/1 * * * * *")
    public void hello() {
        log.info("----------" + t++);
    }
}
