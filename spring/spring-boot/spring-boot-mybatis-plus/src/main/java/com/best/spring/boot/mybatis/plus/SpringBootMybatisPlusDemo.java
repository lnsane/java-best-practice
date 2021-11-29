package com.best.spring.boot.mybatis.plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.best.spring.boot.mybatis.plus.mapper")
public class SpringBootMybatisPlusDemo {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisPlusDemo.class, args);
    }
}
