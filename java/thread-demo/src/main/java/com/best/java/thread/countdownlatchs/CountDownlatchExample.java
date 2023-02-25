package com.best.java.thread.countdownlatchs;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Cunlu Wamg
 */
public class CountDownlatchExample {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(100);
        ThreadFactory threadFactory = r -> {
            Thread thread = new Thread(r);
            thread.setName("my customize thread name : ");
            return thread;
        };
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,
                                                                       10,
                                                                       1000L,
                                                                       TimeUnit.SECONDS,
                                                                       new LinkedBlockingQueue<>(),
                                                                       threadFactory);

        for (int i = 0; i < 100; i++) {
            int finalI = i;
            Runnable runnable = () -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + finalI);
                countDownLatch.countDown();
            };
            threadPoolExecutor.execute(runnable);
        }

        System.out.println("go pre");
        try {
            boolean await = countDownLatch.await(100, TimeUnit.SECONDS);
            if (await) {
                System.out.println("go");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPoolExecutor.shutdown();
    }
}
