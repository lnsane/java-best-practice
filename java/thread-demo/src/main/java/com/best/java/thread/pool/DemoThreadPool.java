package com.best.java.thread.pool;

import java.util.concurrent.*;

/**
 * @author Cunlu Wamg
 */
public class DemoThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,10,100L, TimeUnit.SECONDS,new LinkedBlockingQueue<>());
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        };
        ThreadFactory threadFactory1 = Executors.defaultThreadFactory();


    }
}
