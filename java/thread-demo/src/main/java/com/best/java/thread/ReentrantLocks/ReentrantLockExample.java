package com.best.java.thread.ReentrantLocks;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Cunlu Wamg
 */
public class ReentrantLockExample {
    private static final ReentrantLock reentrantLock = new ReentrantLock();
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                run(finalI);
            }).start();
        }
    }
    public static void run(Integer integer) {
        System.out.println(integer);
        reentrantLock.lock();
        try {
            Thread.sleep(1000);

        } catch (Exception e) {

        } finally {
            reentrantLock.unlock();
        }
    }
}
