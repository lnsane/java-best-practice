package com.ppt;

/**
 * 可见性demo
 * @author Cunlu Wamg
 */
public class VolatileDemo1 {

    boolean flag = false;

    public static void main(String[] args) {
        VolatileDemo1 volatileDemo1 = new VolatileDemo1();
        System.out.println(volatileDemo1.flag);
        Thread thread1 = new Thread(() -> volatileDemo1.setFlag());
        Thread thread2 = new Thread(() -> volatileDemo1.isFlag());
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(volatileDemo1.flag);
    }


    public boolean isFlag() {
        while (!flag) {
        }
        return true;
    }

    public void setFlag() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
    }
}
