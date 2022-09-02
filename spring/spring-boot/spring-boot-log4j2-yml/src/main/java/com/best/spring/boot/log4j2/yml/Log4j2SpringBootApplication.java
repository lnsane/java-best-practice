package com.best.spring.boot.log4j2.yml;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Slf4j
public class Log4j2SpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(Log4j2SpringBootApplication.class, args);
    }

    @PostConstruct
    public void mai2() {
        log.info("info");
        log.error("error");
        log.warn("warn");
        log.debug("debug");
        A a = new A();
        a.setA("1221212");
        log.info("asdasd:{}",a);
    }
}
