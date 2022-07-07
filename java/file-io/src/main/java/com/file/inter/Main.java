package com.file.inter;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    public static void main(String[] args) throws IOException {
        Enumeration<URL> urls =
                ClassLoader.getSystemResources("META-INF/spring.factories");
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            System.out.println(url.getPath());
        }
        MyInterImpl myInter = new MyInterImpl();
        User user = new User();
        System.out.println(user);
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(0,1);
        ThreadLocal<Object> objectThreadLocal = new ThreadLocal<>();
        objectThreadLocal.set("1111");
        System.gc();
        Object o = objectThreadLocal.get();
        System.out.println(o);
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ArrayBlockingQueue<Object> arrayBlockingQueue = new ArrayBlockingQueue<>(10);
        SynchronousQueue<Object> synchronousQueue = new SynchronousQueue<>();
        PriorityBlockingQueue<Object> priorityBlockingQueue = new PriorityBlockingQueue<>(10);
        for (int i = 0; i < 11; i++) {
            synchronousQueue.poll();
            synchronousQueue.add("");
        }
        System.out.println(synchronousQueue.size());
        try {
            reentrantReadWriteLock.readLock().lock();
        }catch (Exception e){

        }finally {
            reentrantReadWriteLock.readLock().unlock();
        }

        try {
            reentrantReadWriteLock.writeLock().lock();
        }catch (Exception e){

        }finally {
            reentrantReadWriteLock.writeLock().unlock();
        }

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("1");
    }
}
