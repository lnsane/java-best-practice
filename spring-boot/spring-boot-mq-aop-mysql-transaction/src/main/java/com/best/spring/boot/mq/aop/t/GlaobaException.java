package com.best.spring.boot.mq.aop.t;

import com.best.spring.boot.mq.aop.t.exception.OrderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

/**
 * @author lnsane
 */
@RestControllerAdvice
public class GlaobaException {
    @ExceptionHandler(value = Exception.class)
    public Object allException(Exception e) {
        HashMap<String, String> map = new HashMap<>();
        map.put("hello", "world");
        return map;
    }

    @ExceptionHandler(value = OrderException.class)
    public Object allException(OrderException e) {
        HashMap<String, String> map = new HashMap<>();
        map.put("hello", "world");
        return map;
    }

}
