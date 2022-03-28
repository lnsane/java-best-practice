package com.best.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/**
 * @author 王存露
 */
@SpringBootApplication
public class SpringBootStartDemo {

    @Autowired
    private AbsInface absInface;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStartDemo.class, args);
    }

    @PostConstruct
    public void test() {
        System.out.println(absInface.sayHello());
    }



}
