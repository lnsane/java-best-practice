package com.best.java.thread.sgement;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
   public static SegmentLock<String> segmentLock = new SegmentLock<>();

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Main.MyThread myThread = new Main.MyThread(i);
            myThread.start();
        }
    }


    static class MyThread extends Thread {
        final String ass = "pay::redis::lock::id::";
        private int anInt;
        public MyThread(int i) {
            this.anInt = i * 123;
        }

        @Override
    public void run() {
        ReentrantLock lock = segmentLock.lock(ass + anInt);
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "-----------------" + anInt);
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e){

        }finally {
            lock.unlock();
        }
    }
}
}
