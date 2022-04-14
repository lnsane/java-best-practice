package com.ppt;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author Cunlu Wamg
 */
public class ThreadDemo1 {
    private static Message message = new Message();
    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            synchronized (message) {
                try {
                    message.wait();
                    System.out.println("1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message.hello();
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (message) {
                try {
                    message.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread3 = new Thread(() -> {
            synchronized (message) {
                try {
                    message.wait();
                } catch (InterruptedException e) {


                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread1.interrupt();
        System.out.println(thread1.getState().name());
        System.out.println(thread2.getState().name());
        System.out.println(thread3.getState().name());
    }
}
