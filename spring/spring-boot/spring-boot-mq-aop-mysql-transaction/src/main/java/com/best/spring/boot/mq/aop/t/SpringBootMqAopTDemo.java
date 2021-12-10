package com.best.spring.boot.mq.aop.t;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;

/**
 * @author lnsane
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "com.best.spring.boot.mq.aop.t.mapper")
public class SpringBootMqAopTDemo {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMqAopTDemo.class,args);
    }
    @PostConstruct
    public void hello() {

    }
}
