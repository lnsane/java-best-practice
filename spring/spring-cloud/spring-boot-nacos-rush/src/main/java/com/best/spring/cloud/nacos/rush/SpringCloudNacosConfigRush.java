package com.best.spring.cloud.nacos.rush;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * @author CunLu Wang
 * @since 2023/5/22
 */
@SpringBootApplication
public class SpringCloudNacosConfigRush {
    @Autowired
    private Hello hello;

    @Value("${hello:}")
    private String world;
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudNacosConfigRush.class,args);
    }
    @PostConstruct
    public void sout() {
        System.out.println(hello.getWorld());
        System.out.println(world);
    }
    @EventListener(classes = ApplicationReadyEvent.class)
    public void run(ApplicationReadyEvent applicationReadyEvent) {
        while (Boolean.TRUE.equals(Boolean.TRUE)) {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(hello.getWorld());
                System.out.println(world);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
