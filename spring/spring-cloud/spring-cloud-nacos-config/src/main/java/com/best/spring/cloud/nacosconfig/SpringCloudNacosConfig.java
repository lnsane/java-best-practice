package com.best.spring.cloud.nacosconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringCloudNacosConfig {
    @Autowired
    private Hello hello;

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudNacosConfig.class, args);
    }

    @Bean
    public Hello hello() {
        return new Hello();
    }

    @PostConstruct
    public void sout() {
        System.out.println(hello.getWorld());
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
