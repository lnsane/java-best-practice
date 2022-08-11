package com.best.spring.boot.activiti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication( exclude = SecurityAutoConfiguration.class)
public class SpringBootActiviti {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootActiviti.class,args);
    }



}
