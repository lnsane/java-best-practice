package com.best.java.thread.wait;

public class WakeUpThread implements Runnable {
    private Msg msg;

    public WakeUpThread(Msg msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        synchronized (msg) {
            System.out.println("notifyAll");
            msg.notifyAll();
        }
    }
}
