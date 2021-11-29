package com.best.spring.redis;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import cn.hutool.core.util.IdUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 王存露
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OutRedisMoney {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    @Test
    public void test() throws InterruptedException {
        final Logger logger = new LoggerContext().getLogger(OutRedisMoney.class);
        int t = 0;
        int i = 0;
        while (true) {
            String fastUUID = IdUtil.fastUUID();
            redisTemplate.opsForValue()
                    .set(fastUUID, fastUUID);
            i++;
            if (i == 1000) {
                Thread.sleep(100);
                t++;
                logger.info("存储数据 {}", t * 1000);
                i = 0;
            }
        }
    }
}
