package com.best.java.thread.wait;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Msg msg = new Msg();
        msg.setContent("hello world");

        TestTread testTread = new TestTread(msg, 1);
        new Thread(testTread).start();

        TestTread testTread2 = new TestTread(msg, 2);
        new Thread(testTread2).start();

        Thread.sleep(10000);
        WakeUpThread wakeUpThread = new WakeUpThread(msg);
        new Thread(wakeUpThread).start();
        WakeUpThread wakeUpThread2 = new WakeUpThread(msg);
        new Thread(wakeUpThread2).start();
    }
}
