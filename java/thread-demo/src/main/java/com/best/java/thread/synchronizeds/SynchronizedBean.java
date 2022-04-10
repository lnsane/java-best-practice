package com.best.java.thread.synchronizeds;

/**
 * @author Cunlu Wamg
 */
public class SynchronizedBean {

    public SynchronizedBean() {
    }

    public synchronized static void synchronizedBeanMethod() {
        System.out.println("lock");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("unlock");
    }

    public static void main(String[] args) {
        synchronizedBeanMethod();
        synchronizedBeanMethod();
    }
}
