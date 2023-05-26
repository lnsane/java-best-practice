//package com.best.spring.cloud.openfeign.config;
//
//import feign.RequestInterceptor;
//import feign.RequestTemplate;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
///**
// * @author lnsane
// */
////@Component
//public class MyFeign implements RequestInterceptor {
//    private final static Logger log = LoggerFactory.getLogger(RequestInterceptor.class);
//
//    @Override
//    public void apply(RequestTemplate requestTemplate) {
//        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        log.info("===request: {}", requestTemplate.url());
//    }
//}
