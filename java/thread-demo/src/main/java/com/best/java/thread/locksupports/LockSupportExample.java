package com.best.java.thread.locksupports;

import java.util.concurrent.locks.LockSupport;

/**
 * @author Cunlu Wamg
 */
public class LockSupportExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("准备开始");
            LockSupport.park();
            System.out.println("结束");
        });
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        if (thread.isInterrupted()) {
            System.out.println("yes");
        }
//        LockSupport.unpark(thread);
    }
}
