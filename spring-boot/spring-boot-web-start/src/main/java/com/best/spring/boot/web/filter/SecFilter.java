package com.best.spring.boot.web.filter;

import ch.qos.logback.classic.LoggerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author 王存露
 */
@Component
@Order(value = 0)
public class SecFilter implements Filter {

    Logger logger = LoggerFactory.getLogger(SecFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("-----> sec Filter init");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("-----> sec Filter run");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        logger.info("-----> sec Filter destroy");
        Filter.super.destroy();
    }
}
