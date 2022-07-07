package com.best.java.thread.countdownlatchs;

public class Threads {
    public static void main(String[] args) {
        try {
            System.out.println(1);
            if (1 / 0 == 1)
                System.exit(1);
            return;
        } catch (Exception e) {
            System.out.println(4);
        } finally {
            System.out.println(2);
        }
        System.out.println(3);
    }
}
