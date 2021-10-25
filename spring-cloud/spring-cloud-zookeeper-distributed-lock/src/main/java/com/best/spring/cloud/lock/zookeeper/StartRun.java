package com.best.spring.cloud.lock.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

enum LockTypeEnums {
    LOCK_SHARE("分布式可重入排它锁"),
    LOCK_ANYTHING("分布式排它锁"),
    READ_WRITE_LOCK_READ("读写锁 读"),
    READ_WRITE_LOCK_WRITE("读写锁 写");

    private String msg;

    LockTypeEnums(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}

@Component

public class StartRun implements ApplicationListener<ApplicationStartedEvent> {
    Logger logger = LoggerFactory.getLogger(StartRun.class);
    @Autowired
    private CuratorFramework curatorFramework;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        String lockPath = "/lock";

//        logger.info("分布式可重入排它锁 开始");
//        // 分布式可重入排它锁
//        InterProcessMutex interProcessMutex = new InterProcessMutex(curatorFramework, lockPath);
//        //模拟50个线程抢锁
//        for (int i = 0; i < 4; i++) {
//            new Thread(new TestThread(i, interProcessMutex,LockTypeEnums.LOCK_SHARE)).start();
//        }
//
//        logger.info("分布式可重入排它锁 结束");

//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        logger.info("分布式排它锁 开始");
//
//        // 分布式排它锁
//        InterProcessSemaphoreMutex interProcessSemaphoreMutex = new InterProcessSemaphoreMutex(curatorFramework,lockPath);
//
//        //模拟50个线程抢锁
//        for (int i = 0; i < 4; i++) {
//            new Thread(new TestThread(i, interProcessSemaphoreMutex,LockTypeEnums.LOCK_ANYTHING)).start();
//        }
//        logger.info("分布式排它锁 结束");

//
//
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        分布式读写锁
//        InterProcessReadWriteLock interProcessReadWriteLockWrite = new InterProcessReadWriteLock(curatorFramework, lockPath);
//
//        for (int i = 0; i < 2; i++) {
//            new Thread(new TestThread(i, interProcessReadWriteLockWrite.writeLock(), LockTypeEnums.READ_WRITE_LOCK_WRITE)).start();
//        }

        // 分布式读写锁
        InterProcessReadWriteLock interProcessReadWriteLockRead = new InterProcessReadWriteLock(curatorFramework, lockPath);

        for (int i = 0; i < 10; i++) {
            new Thread(new TestThread(i, interProcessReadWriteLockRead.writeLock(), LockTypeEnums.READ_WRITE_LOCK_READ)).start();
        }
    }
}

class TestThread implements Runnable {

    Logger logger = LoggerFactory.getLogger(StartRun.class);

    private Integer threadFlag;
    private InterProcessLock lock;
    private LockTypeEnums lockTypeEnums;

    public TestThread(Integer threadFlag, InterProcessLock lock, LockTypeEnums lockTypeEnums) {
        this.threadFlag = threadFlag;
        this.lock = lock;
        this.lockTypeEnums = lockTypeEnums;
    }

    @Override
    public void run() {
        try {
            lock.acquire();
            logger.info("当前锁的类型 ： {} 第 {} 线程获得锁", lockTypeEnums.getMsg(), threadFlag);
            //等到1秒后释放锁
            if (lockTypeEnums.equals(LockTypeEnums.READ_WRITE_LOCK_READ)) {
                Thread.sleep(1000);
            } else if (lockTypeEnums.equals(LockTypeEnums.READ_WRITE_LOCK_WRITE)) {
                Thread.sleep(5000);
            } else if (lockTypeEnums.equals(LockTypeEnums.LOCK_SHARE)) {
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                lock.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}