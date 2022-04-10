package com.best.java.thread.cyclicbarriers;

import java.util.concurrent.*;

/**
 * @author Cunlu Wamg
 */
public class CyclicbarrierExmaple {
    private static final Integer CORE_THREAD_NUMBER = 6;

    private static final Integer MAX_THREAD_NUMBER = 10;

    private static final Long WAIT_TIME = 10L;

    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;

    private static final LinkedBlockingQueue<Runnable> LinkedBlockingQueue = new LinkedBlockingQueue<>();


    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5,() -> {
            System.out.println("----------------------");
        });
        ThreadFactory threadFactory = Thread::new;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_THREAD_NUMBER,
                                                                       MAX_THREAD_NUMBER,
                                                                       WAIT_TIME,
                                                                       TIME_UNIT,
                                                                       LinkedBlockingQueue,
                                                                       threadFactory);
        for (int i = 0; i < 11; i++) {
            int finalI = i;
            Runnable runnable = () -> {
                System.out.println("准备跑" + finalI);
                try {
                    Thread.sleep((long) (1000 * Math.random()));
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("开炮"+ finalI);
            };
//            new Thread(runnable).start();
            threadPoolExecutor.execute(runnable);
        }
        threadPoolExecutor.shutdown();

    }
}
