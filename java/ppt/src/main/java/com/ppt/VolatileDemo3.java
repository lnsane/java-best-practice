package com.ppt;

/**
 * 原子性
 * @author Cunlu Wamg
 */
public class VolatileDemo3 {

    static int x = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    x++;
                }
            }
        });
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    x++;
                }
            }
        });
        thread.start();
        thread1.start();
        thread1.join();
        thread.join();
        System.out.println(x);
    }
}
