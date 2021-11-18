package com.best.java.thread.join;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        JoinTest joinTest = new JoinTest();
        ForJoinTest forJoinTest = new ForJoinTest();
        Thread thread = new Thread(joinTest);
        thread.start();
//        thread.join();
//        thread.interrupt();
        new Thread(forJoinTest).start();
    }
}
