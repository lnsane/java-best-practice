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
@Order(value = Integer.MAX_VALUE - 1)
public class FirstFilter implements Filter {

    Logger logger = LoggerFactory.getLogger(FirstFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("-----> first Filter init");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("-----> first Filter run");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        logger.info("-----> first Filter destroy");
        Filter.super.destroy();
    }
}
