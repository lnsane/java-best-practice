package com.best.spring.boot.aop.apest;

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
public class ApestTest {
    private final static Logger log = LoggerFactory.getLogger(ApestTest.class);

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void controller() {
    }

    @Before(value = "controller()")
    public void before() {
        log.info("before");
    }

    @After(value = "controller()")
    public void after() {
        log.info("after");
    }

    @AfterReturning(value = "controller()")
    public void afterReturning(JoinPoint joinPoint) {
        log.info("afterReturning");
    }

    @AfterThrowing(value = "controller()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        log.info("afterThrowing");
    }


    @Around(value = "controller()")
    public Object pointcut(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("pointcut before");
        Object proceed = joinPoint.proceed();
        log.info("pointcut after");
        return proceed;
    }
}
