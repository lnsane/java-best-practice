package com.best.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/**
 * @author 王存露
 */
@SpringBootApplication
public class SpringBootStartDemo {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStartDemo.class, args);
    }

    @PostConstruct
    public void test() {
        ServiceB serviceB = new ServiceB(new ServiceA(new ServiceC()));
        serviceB.setServiceB();
        System.out.println(System.getProperty("sun.jnu.encoding"));
    }



}
