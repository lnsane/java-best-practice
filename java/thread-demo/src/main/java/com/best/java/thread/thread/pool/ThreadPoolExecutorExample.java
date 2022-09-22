package com.best.java.thread.thread.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Cunlu Wamg
 */
public class ThreadPoolExecutorExample {
   private static volatile List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,
                                                                       10,
                                                                       10,
                                                                       TimeUnit.SECONDS,
                                                                       new ArrayBlockingQueue<>(500000, true),
                                                                       Thread::new,
                                                                       new ThreadPoolExecutor.AbortPolicy());

        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 100; i++) {
                int finalI = i;
                Runnable runnable = () -> {
//                try {
//                    Thread.sleep(1000);
                    synchronized (ThreadPoolExecutorExample.class) {
                        list.add(finalI);
                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                    System.out.println(finalI);
                };
                try {
                    threadPoolExecutor.execute(runnable);
                } catch (Exception e) {
                    System.out.println(e + "-----------" + i);
                }
            }
        }
        threadPoolExecutor.shutdown();
        System.out.println("end");
        while (!threadPoolExecutor.isTerminated()) {

        }
        System.out.println("end");
        while (threadPoolExecutor.awaitTermination(10,TimeUnit.SECONDS)) {
            System.out.println("list size :" + list.size());
            for (int i = 0; i < list.size(); i++) {
                System.out.println( "--------" + list.get(i));
            }
            break;
        }
    }
}
