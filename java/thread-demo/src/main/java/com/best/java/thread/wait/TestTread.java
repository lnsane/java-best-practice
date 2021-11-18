package com.best.java.thread.wait;

public class TestTread implements Runnable {

    private Msg msg;
    private Integer i;

    public TestTread(Msg msg, Integer i) {
        this.msg = msg;
        this.i = i;
    }


    @Override
    public void run() {
        synchronized (msg) {
            try {
                msg.wait(5000, 5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("测试 : " + i);
        }
    }

}
