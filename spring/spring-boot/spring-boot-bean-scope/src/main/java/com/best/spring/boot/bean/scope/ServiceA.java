package com.best.spring.boot.bean.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Cunlu Wamg
 */
@Component
public class ServiceA {
    private final ReentrantLock reentrantLock = new ReentrantLock(true);
    public void test() {
        reentrantLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "锁住");
            Thread.sleep(10000);
        } catch (Exception e) {

        } finally {
            reentrantLock.unlock();
            System.out.println(Thread.currentThread().getName() + "锁释放");
        }
    }
}
