package com.best.spring.boot.mybatis.plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
@MapperScan(value = "com.best.spring.boot.mybatis.plus.mapper")
public class SpringBootMybatisPlusDemo {
//    public static void main(String[] args) {
//        SpringApplication.run(SpringBootMybatisPlusDemo.class, args);
//    }

    public static void main(String[] args) {
        List<String> ts;
        ts = null;
        List<String> collect = Optional.ofNullable(ts).orElse(Collections.emptyList()).stream().collect(Collectors.toList());
        System.out.println(collect);
    }
}
