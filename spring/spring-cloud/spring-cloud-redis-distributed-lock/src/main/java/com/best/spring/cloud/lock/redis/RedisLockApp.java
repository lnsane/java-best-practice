package com.best.spring.cloud.lock.redis;

import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RedisLockApp {
    Logger logger = LoggerFactory.getLogger(RedisLockApp.class);
    @Autowired
    private RedissonClient redissonClient;

    public static void main(String[] args) {
        SpringApplication.run(RedisLockApp.class, args);
    }

    @PostConstruct
    public void testLock() {
        for (int i = 0; i < 2; i++) {
            new Thread(new TestThread(i, redissonClient)).start();
        }
    }

    //    @Scheduled(fixedDelay = 10000)
    public void hello() {
        logger.info("心跳检查");
    }
}


class TestThread implements Runnable {

    Logger logger = LoggerFactory.getLogger(TestThread.class);

    private Integer threadFlag;
    private RedissonClient redissonClient;

    public TestThread(Integer threadFlag, RedissonClient redissonClient) {
        this.threadFlag = threadFlag;
        this.redissonClient = redissonClient;
    }

    @Override
    public void run() {
        String key = "dec_store_lock_threadFlag";

        RLock lock = redissonClient.getFairLock(key);
//        if (lock.tryLock()) {
        try {
            lock.lock(10, TimeUnit.SECONDS);
            logger.info("当前锁的类型 ： 第 {} 线程  获得  锁", threadFlag);
            //等到1秒后释放锁
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                logger.info("当前锁的类型 ： 第 {} 线程  释放  锁", threadFlag);
                lock.unlock();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//        } else {
//            logger.info("当前锁的类型 ： 第 {} 没有  得到  锁", threadFlag);
//        }

    }
}

