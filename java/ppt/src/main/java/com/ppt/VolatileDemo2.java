package com.ppt;

/**
 * 指针重排
 * @author Cunlu Wamg
 */
public class VolatileDemo2 {

     static int x = 0, y = 0;
     static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        int t = 1;
        while(true) {
            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    a = 1;
                    x = b;
                }
            });

            Thread other = new Thread(new Runnable() {
                @Override
                public void run() {
                    b = 1;
                    y = a;
                }
            });
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            one.start();other.start();
            one.join();other.join();
            System.out.println("次数 :" + t + " x :" + x + " y :" + y);
            t++;
        }
    }
}
