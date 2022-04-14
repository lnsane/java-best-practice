package com.best.java.thread.wait;

import javax.xml.ws.Service;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Cunlu Wamg
 */
public class WaitThred {
    // 使用的对象
    public static Msg msg = new Msg();
    public static Msg msg2 = new Msg();

    synchronized public static void oflock() {
        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();
        try {
            lock();
        } catch (Exception e) {

        }finally {
            reentrantLock.unlock();
        }
    }

    synchronized public static void lock() {
        System.out.println(Thread.currentThread() + "锁住");
        try {
            msg.wait(20000);
//                    Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + "马上释放");
    }

    static class Thread0 extends Thread {
        @Override
        public void run() {
            // 使用同步锁 锁住
            oflock();
        }
    }


    static class Thread01 extends Thread {
        @Override
        public void run() {
            synchronized (msg) {
                long l = System.currentTimeMillis();
                System.out.println(Thread.currentThread()  + "锁住2");
                try {
//                    Thread.sleep(20000);
                    msg.wait(20000);
                    long l1 = System.currentTimeMillis();
                    System.out.println(l1 - l);
//                    msg.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "马上释放2");
            }
        }
    }


    static class Thread1 extends Thread {
        @Override
        public void run() {
            // 随机唤醒其他一个线程
            synchronized (msg) {
                msg.notifyAll();
                System.out.println("解放");
            }
        }
    }

    static class MyThread extends Thread {
        private ServiceA serviceA;
        public MyThread(ServiceA serviceA ) {
            this.serviceA = serviceA;
        }

        @Override
        public void run() {
            super.run();
            serviceA.testMethod();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread0 thread0 = new Thread0();
        Thread0 thread001 = new Thread0();
        Thread1 thread1 = new Thread1();
        Thread01 thread01 = new Thread01();
        Thread01 thread02 = new Thread01();
        thread001.start();
        thread01.start();
        thread02.start();
//        thread0.start();
//        thread0.start();
//        Thread.sleep(11111);
//        thread1.start();
//        thread01.join(50000);
//        thread0.interrupt();
//        thread0.join();
//        System.out.println(":1");
//        thread1.start();
//        ServiceA serviceA = new ServiceA();
//        for (int i = 0; i < 100; i++) {
//            new MyThread(new ServiceA()).start();
//        }
    }

}
