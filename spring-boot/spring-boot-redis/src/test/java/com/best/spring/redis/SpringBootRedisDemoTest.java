package com.best.spring.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.stream.Record;
import org.springframework.data.redis.connection.stream.RecordId;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringBootRedisDemoTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void stringOpt() {
        redisTemplate.opsForValue()
                     .setIfAbsent("123", "ADMIN", Duration.ofSeconds(120));
    }

    @Test
    public void listOpt() {
        String LIST_CONST = "LIST_TEST";
//        redisTemplate.opsForList().rightPush(LIST_CONST,"1");
//        redisTemplate.opsForList().rightPush(LIST_CONST,"2");
//        redisTemplate.opsForList().rightPush(LIST_CONST,"3");
        Long size = redisTemplate.opsForList()
                                 .size(LIST_CONST);
        System.out.println(size);
        redisTemplate.opsForList()
                     .leftPop(LIST_CONST, Duration.ofSeconds(20));
    }

    @Test
    public void mapOpt() {
        String MAP_CONST = "MAP_TEST";
        redisTemplate.opsForHash()
                     .put(MAP_CONST, 1, "123");
        redisTemplate.opsForHash()
                     .put(MAP_CONST, 12, "1231");
        redisTemplate.opsForHash()
                     .put(MAP_CONST, 123, "1231");
        redisTemplate.opsForHash()
                     .put(MAP_CONST, 123, "1231111");
    }

    @Test
    public void setOpt() {
        redisTemplate.opsForGeo()
                     .add("asd", new Point(12, 22), 1234);
        List<Point> asd = redisTemplate.opsForGeo()
                                       .position("asd", 1234);
        for (Point point : asd) {
            System.out.println(point.getX());
            System.out.println(point.getY());
        }
    }

    @Test
    public void setOpt2() {
        redisTemplate.opsForZSet().add("123","456",123);
        redisTemplate.opsForZSet().add("123","457",1234);
    }

    @Test
    public void setOpt3() {
        redisTemplate.opsForSet().add("999","12","123","1234","11","11");
    }

    @Test
    public void setOpt4() {
        redisTemplate.opsForHyperLogLog().add("123123","123123");
    }

    @Test
    public void setOpt5() {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("123","11");
        RecordId add = redisTemplate.opsForStream()
                                    .add(Record.of(1).withStreamKey("111"));
        System.out.println(add);

    }
}