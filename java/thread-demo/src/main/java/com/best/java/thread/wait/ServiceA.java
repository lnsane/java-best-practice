package com.best.java.thread.wait;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Cunlu Wamg
 */
public class ServiceA {
    private final ReentrantLock reentrantLock = new ReentrantLock();
    public void testMethod(){
        reentrantLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "锁");
            Thread.sleep(10000);
            System.out.println(reentrantLock.getHoldCount());
        } catch (Exception e) {

        } finally {
            reentrantLock.unlock();
            System.out.println(Thread.currentThread().getName() + "释放锁");
        }
    }
}
