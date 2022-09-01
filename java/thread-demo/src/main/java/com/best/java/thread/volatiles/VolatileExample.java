package com.best.java.thread.volatiles;

/**
 * @author Cunlu Wamg
 */
public class VolatileExample {


    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        while(true) {
            if (MyThread.getFlag()) {
                break;
            } else {
                System.out.println("flag is false");
            }
        }

    }
    public static class MyThread extends Thread {
        public static  Boolean getFlag() {
            return flag;
        }

        public static void setFlag(Boolean flag) {
            MyThread.flag = flag;
        }

        private static volatile Boolean flag = false;
        @Override
        public void run() {
            super.run();
            flag = Boolean.TRUE;
        }
    }
}
