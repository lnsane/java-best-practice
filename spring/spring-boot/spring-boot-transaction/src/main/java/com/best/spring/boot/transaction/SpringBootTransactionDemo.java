package com.best.spring.boot.transaction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author lnsane
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan(value = "com.best.spring.boot.transaction.mapper")
public class SpringBootTransactionDemo {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootTransactionDemo.class, args);
    }
}
