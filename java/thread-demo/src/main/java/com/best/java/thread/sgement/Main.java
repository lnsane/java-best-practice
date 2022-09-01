package com.best.java.thread.sgement;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
   public static SegmentLock<Integer> segmentLock = new SegmentLock<>();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Main.MyThread myThread = new Main.MyThread(i);
            myThread.start();
        }
    }


    static class MyThread extends Thread {
        private int anInt;
        public MyThread(int i) {
            this.anInt = i;
        }

        @Override
    public void run() {
        ReentrantLock lock = segmentLock.lock(anInt);
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "-----------------" + anInt);
            TimeUnit.SECONDS.sleep(10);
        } catch (Exception e){

        }finally {
            lock.unlock();
        }
    }
}
}
