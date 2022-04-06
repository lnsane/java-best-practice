package com.best.java.thread.join;

public class Main {
    //    public static void main(String[] args) throws InterruptedException {
//        JoinTest joinTest = new JoinTest();
//        ForJoinTest forJoinTest = new ForJoinTest();
//        Thread thread = new Thread(joinTest);
//        thread.start();
////        thread.join();
////        thread.interrupt();
//        new Thread(forJoinTest).start();
//    }
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                loopOfWait(finalI);
            });
            thread.start();
            try {
                thread.wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized static void loop(Integer integer) {
        System.out.println(integer);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    synchronized static void loopOfWait(Integer integer) {
        System.out.println(integer);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
