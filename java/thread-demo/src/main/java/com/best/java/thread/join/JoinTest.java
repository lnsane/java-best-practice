package com.best.java.thread.join;

public class JoinTest implements Runnable {

    @Override
    public void run() {
        System.out.println("JoinTest test start");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("runnable test end");
    }
}
