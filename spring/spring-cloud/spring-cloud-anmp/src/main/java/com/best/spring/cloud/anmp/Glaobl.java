package com.best.spring.cloud.anmp;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author lnsane
 */
@Aspect
@Component
public class Glaobl {
    private final static Logger log = LoggerFactory.getLogger(Glaobl.class);

    private final static String key = "Puting";


    @Pointcut("execution(public * com.best.spring.cloud.anmp.MqConsume.consume(..))")
    public void controller() {
    }

    @Before(value = "controller()")
    public void before() {
        log.info("before");

    }

    @After(value = "controller()")
    public void after(JoinPoint joinPoint) {
        log.info("after");

    }

    @AfterReturning(value = "controller()")
    public void afterReturning(JoinPoint joinPoint) {
        log.info("afterReturning");
//        if (order.getState().equals(1) || order.getState().equals(2))

    }

    @AfterThrowing(value = "controller()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        log.info("afterThrowing");
    }


    @Around(value = "controller()")
    public Object pointcut(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("pointcut before");
        joinPoint.proceed();
        return null;
    }
}
