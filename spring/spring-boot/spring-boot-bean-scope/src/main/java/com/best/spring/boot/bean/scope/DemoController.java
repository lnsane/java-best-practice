package com.best.spring.boot.bean.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Cunlu Wamg
 */
@RestController
@Scope(WebApplicationContext.SCOPE_APPLICATION)
public class DemoController {
    private final ReentrantLock reentrantLock = new ReentrantLock(true);
    private final ServiceA serviceA;

    public DemoController(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    @GetMapping(value = "/hello")
    public void hello() {
//        serviceA.test();
        reentrantLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "锁住");
            Thread.sleep(10000);
            System.out.println(Thread.currentThread().getName() + "锁释放");
        } catch (Exception e) {

        } finally {
            reentrantLock.unlock();
        }
    }
}
