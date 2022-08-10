package com.best.spring.boot.click.house;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

import java.util.ArrayList;
import java.util.List;

import static cn.hutool.core.date.DatePattern.NORM_DATETIME_PATTERN;

@SpringBootApplication
@Slf4j
public class ClickHouseApplication implements ApplicationListener<ApplicationStartedEvent> {


    public static void main(String[] args) {
        SpringApplication.run(ClickHouseApplication.class, args);
    }

    @Autowired
    private UserService userService;


    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        log.info("start");
        for (;;)  {
            List<User> list = new ArrayList<>();
            for (int j = 0; j < 99; j++) {
                list.add(User.builder()
                        .id(IdUtil.getSnowflakeNextId()).number(RandomUtil.randomLong(0, 10000000000L))
                        .username(RandomUtil.randomString(15))
                        .age(RandomUtil.randomInt(1, 120))
                        .money(RandomUtil.randomInt(2500, 9999999))
                        .area(RandomUtil.randomString(10))
                        .createTime(String.valueOf(DateUtil.format(RandomUtil.randomDay(-10000, -1), NORM_DATETIME_PATTERN)))
                        .build());
            }
            userService.saveBatch(list);
        }
    }
}
