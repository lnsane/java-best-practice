package com.best.spring.boot.mq.aop.t.content;

import com.best.spring.boot.mq.aop.t.model.Order;

/**
 * @author lnsane
 */
public class LocalThread {
    private final static ThreadLocal<Order> localOrder = new ThreadLocal<>();
    public static void set(Order order) {
        localOrder.set(order);
    }
    public static Order get() {
        return localOrder.get();
    }
}
