package com.best.spring.boot.web.event;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;

/**
 * @author 王存露
 */
@Component
public class RequestEvent {
    private final Log log = LogFactory.getLog(getClass());
    @EventListener(value = ServletRequestHandledEvent.class)
    public void request(ServletRequestHandledEvent servletRequestHandledEvent){
        log.info(servletRequestHandledEvent.getServletName());
        log.info(servletRequestHandledEvent.getRequestUrl());
        log.info(servletRequestHandledEvent.getClientAddress());
        log.info(servletRequestHandledEvent.getDescription());
        log.info(servletRequestHandledEvent.getMethod());
        log.info(servletRequestHandledEvent.getShortDescription());
        log.info(servletRequestHandledEvent.getStatusCode());
    }
}
