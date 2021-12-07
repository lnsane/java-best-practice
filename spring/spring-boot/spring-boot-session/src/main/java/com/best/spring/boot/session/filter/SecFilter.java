package com.best.spring.boot.session.filter;


import com.best.spring.boot.session.warpper.SessionRepositoryRequestWrapper2;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 王存露
 */
//@Component
//@Order(value = 0)
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
        SessionRepositoryRequestWrapper2 customRequest =
                new SessionRepositoryRequestWrapper2(httpRequest);
        HttpSession session = customRequest.getSession();
        chain.doFilter(customRequest, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
