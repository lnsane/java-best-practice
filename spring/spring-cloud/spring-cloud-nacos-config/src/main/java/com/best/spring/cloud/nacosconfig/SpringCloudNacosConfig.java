package com.best.spring.cloud.nacosconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringCloudNacosConfig {
    @Autowired
    private Hello hello;

    @Autowired
    private Hello2 hello2;
    @Value("${pig}")
    private String pig;

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudNacosConfig.class, args);
    }

    @Bean
    public Hello hello() {
        return new Hello();
    }

    @Bean
    public Hello2 hello2() {
        return new Hello2();
    }

    @PostConstruct
    public void sout() {
        System.out.println(hello.getWorld());
        System.out.println(hello2.getWorld());
        System.out.println(pig);
    }
}

@ConfigurationProperties(value = "hello")
class Hello {

    private String world;

    public String getWorld() {
        return world;
    }

    public void setWorld(String world) {
        this.world = world;
    }
}

@ConfigurationProperties(value = "wang")
class Hello2 {

    private String world;

    public String getWorld() {
        return world;
    }

    public void setWorld(String world) {
        this.world = world;
    }
}
