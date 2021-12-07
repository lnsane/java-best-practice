package com.best.spring.boot.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 王存露
 */
@Order(value = 2)
public class SecInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(SecInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info(" -----> SecInterceptor run pre");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info(" -----> SecInterceptor run post");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info(" -----> SecInterceptor run after");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }


    private String main(String name) {
        if (name.length() > 0) {
            if (name.charAt(0) == ',') {
                return name.replaceFirst(",", "");
            }
        }
        return name;
    }
}
