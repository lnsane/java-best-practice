package com.best.java.thread.semaphores;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Cunlu Wamg
 */
public class SemaphoreExample {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1,true);
        for (int i = 0; i < 1; i++) {
            if (semaphore.tryAcquire(1,5, TimeUnit.SECONDS)) {
                int finalI = i;
                new Thread(() -> {
                    try {
                        semaphore.tryAcquire(1,5, TimeUnit.SECONDS);
                        System.out.println("lock " + finalI);
                        Thread.sleep(1000);
                        System.out.println("unlock " + finalI);
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();

                new Thread(() -> {
                    try {
                        semaphore.acquire();
                        System.out.println("lock " + finalI);
                        Thread.sleep(1000);
                        System.out.println("unlock " + finalI);
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
                System.out.println("----------------");
            }
        }
    }
}
