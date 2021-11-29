package com.best.spring.boot.session.filter;


import com.best.spring.boot.session.warpper.SessionRepositoryRequestWrapper;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 王存露
 */
@Component
@Order(value = 0)
public class SecFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session1 = ((HttpServletRequest) request).getSession();
        System.out.println(session1.getAttribute("username"));
        SessionRepositoryRequestWrapper customRequest =
                new SessionRepositoryRequestWrapper(httpRequest);
        HttpSession session = customRequest.getSession();
        Object username = session.getAttribute("username");
        System.out.println(username);
        chain.doFilter(customRequest, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
