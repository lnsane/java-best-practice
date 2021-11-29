package com.best.spring.boot.web;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author 王存露
 */
@SpringBootApplication
public class SpringBootWebTomcatStart {
    public static void main(String[] args) {
//        SpringApplication.run(SpringBootWebTomcatStart.class, args);
        new SpringApplicationBuilder()
                .sources(SpringBootWebTomcatStart.class)
                .run(args);
    }
}
