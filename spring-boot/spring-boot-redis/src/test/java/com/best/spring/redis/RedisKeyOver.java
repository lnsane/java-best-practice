package com.best.spring.redis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisKeyOver {
    final String REDIS_KEY1 = "REDIS_KEY1_";
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private StringRedisTemplate redisTemplate1;

    /**
     * 测试一下redis key 覆盖问题
     */
    @Test
    public void test() {
        redisTemplate.opsForValue().setIfAbsent(REDIS_KEY1 + "1", String.valueOf(1));
        Object o = redisTemplate.opsForValue().get(REDIS_KEY1 + "1");
        Assert.assertEquals(o, "1");
    }

    @Test
    public void test2() {
        redisTemplate1.opsForValue().setIfAbsent(REDIS_KEY1 + "2", String.valueOf(2));
        String s = redisTemplate1.opsForValue().get(REDIS_KEY1 + "2");
        Assert.assertEquals(s, "2");
        Long increment = redisTemplate1.opsForValue().increment(REDIS_KEY1 + "2", 1);
        Optional.ofNullable(increment).ifPresent(aLong -> {
            Assert.assertEquals(aLong, Long.valueOf("3"));
        });
    }

    @Test
    public void test3() {
        Long increment = redisTemplate1.opsForValue().increment(REDIS_KEY1 + "4", 1);
        increment = redisTemplate1.opsForValue().increment(REDIS_KEY1 + "4", 1);
        increment = redisTemplate1.opsForValue().increment(REDIS_KEY1 + "4", 1);
        increment = redisTemplate1.opsForValue().increment(REDIS_KEY1 + "4", 1);
        redisTemplate1.delete(REDIS_KEY1 + "4");
        System.out.println("key is : " + increment);
        Assert.assertNotNull(increment);
    }

    @Test
    public void test4() {
        Boolean delete = redisTemplate1.delete("111");
        Assert.assertFalse(delete);
    }
}
