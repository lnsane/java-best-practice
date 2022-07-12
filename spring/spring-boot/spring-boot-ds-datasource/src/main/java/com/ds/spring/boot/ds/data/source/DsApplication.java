package com.ds.spring.boot.ds.data.source;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DsApplication {
    public static void main(String[] args) {
        SpringApplication.run(DsApplication.class, args);
    }

}
