package com.best.spring.redis;

import com.best.spring.redis.model.Model2;
import com.best.spring.redis.model.RedisModel;
import org.redisson.Redisson;
import org.redisson.api.RLiveObjectService;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.PostConstruct;

/**
 * @author 王存露
 */
@SpringBootApplication
public class SpringBootRedisDemo {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRedisDemo.class, args);
    }
}
