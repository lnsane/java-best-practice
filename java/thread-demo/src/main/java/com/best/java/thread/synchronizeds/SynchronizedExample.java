package com.best.java.thread.synchronizeds;

/**
 * @author Cunlu Wamg
 */
public class SynchronizedExample {
    public static class MySynchronized {
        private volatile static MySynchronized singleton;
        private MySynchronized (){}
        public static MySynchronized getSingleton() {
            if (singleton == null) {
                synchronized (MySynchronized.class) {
                    if (singleton == null) {
                        singleton = new MySynchronized();
                    }
                }
            }
            return singleton;
        }

        public synchronized static void hello() {
            System.out.println("hello lock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello unlock");
        }

        public synchronized static void hello2() {
            System.out.println("hello2 lock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello2 unlock");
        }

        public synchronized void hi() {
            System.out.println("hi lock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hi unlock");
        }

        public synchronized void hi2() {
            synchronized (this) {
                System.out.println("hi2 lock");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hi2 unlock");
            }
        }


        public static   void hi3() {
            System.out.println("hi3 lock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hi3 unlock");
        }
    }

    public static void main(String[] args) {
        MySynchronized mySynchronized = MySynchronized.getSingleton();
        new Thread(() -> {
            MySynchronized.hello2();
        }).start();

        new Thread(() -> {
            MySynchronized.hello2();
        }).start();

        new Thread(() -> {
            run();
        }).start();
//
//        new Thread(() -> {
//            MySynchronized mySynchronized = MySynchronized.getSingleton();
//            mySynchronized.hi();
//        }).start();
//
//
//        new Thread(() -> {
//            MySynchronized mySynchronized = MySynchronized.getSingleton();
//            mySynchronized.hi2();
//        }).start();
//
//        new Thread(() -> {
//            MySynchronized mySynchronized = MySynchronized.getSingleton();
//            mySynchronized.hi3();
//        }).start();



    }

    public static void run() {
        synchronized (MySynchronized.class) {
            System.out.println("hello3 lock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello3 unlock");
        }
    }
}
