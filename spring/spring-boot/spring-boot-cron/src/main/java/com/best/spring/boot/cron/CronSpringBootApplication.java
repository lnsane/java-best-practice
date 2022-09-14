package com.best.spring.boot.cron;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;

/**
 * @author CunLu Wang
 * @since 2022/9/14
 */
@SpringBootApplication
@EnableScheduling
@Slf4j
public class CronSpringBootApplication {

    private Integer integer = 0;

    public static void main(String[] args) {
        SpringApplication.run(CronSpringBootApplication.class,args);
    }

    @Schedules({
            @Scheduled(cron = "*/6 * * * * *"),
            @Scheduled(cron = "*/3 * * * * *")
    })
    public void hello() {
      log.info(String.valueOf(integer++));
    }
}
