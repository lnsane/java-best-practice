package com.best.spring.boot.session.warpper;

import org.springframework.session.Session;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author 王存露
 */
public class SessionRepositoryRequestWrapper2<S extends Session> extends HttpServletRequestWrapper {

    private S requestedSession;

    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request The request to wrap
     * @throws IllegalArgumentException if the request is null
     */
    public SessionRepositoryRequestWrapper2(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getAuthType() {
        return super.getAuthType();
    }

    @Override
    public Cookie[] getCookies() {
        return super.getCookies();
    }

    @Override
    public long getDateHeader(String name) {
        return super.getDateHeader(name);
    }

    @Override
    public String getHeader(String name) {
        return super.getHeader(name);
    }

    @Override
    public Enumeration<String> getHeaders(String name) {
        return super.getHeaders(name);
    }

    @Override
    public Enumeration<String> getHeaderNames() {
        return super.getHeaderNames();
    }

    @Override
    public int getIntHeader(String name) {
        return super.getIntHeader(name);
    }

    @Override
    public HttpServletMapping getHttpServletMapping() {
        return super.getHttpServletMapping();
    }

    @Override
    public String getMethod() {
        return super.getMethod();
    }

    @Override
    public String getPathInfo() {
        return super.getPathInfo();
    }

    @Override
    public String getPathTranslated() {
        return super.getPathTranslated();
    }

    @Override
    public String getContextPath() {
        return super.getContextPath();
    }

    @Override
    public String getQueryString() {
        return super.getQueryString();
    }

    @Override
    public String getRemoteUser() {
        return super.getRemoteUser();
    }

    @Override
    public boolean isUserInRole(String role) {
        return super.isUserInRole(role);
    }

    @Override
    public Principal getUserPrincipal() {
        return super.getUserPrincipal();
    }

    @Override
    public String getRequestedSessionId() {
        return super.getRequestedSessionId();
    }

    @Override
    public String getRequestURI() {
        return super.getRequestURI();
    }

    @Override
    public StringBuffer getRequestURL() {
        return super.getRequestURL();
    }

    @Override
    public String getServletPath() {
        return super.getServletPath();
    }

    @Override
    public HttpSession getSession(boolean create) {
        return super.getSession(create);
    }

    @Override
    public HttpSession getSession() {
        return null;
    }

    @Override
    public String changeSessionId() {
        return super.changeSessionId();
    }

    @Override
    public boolean isRequestedSessionIdValid() {
        return super.isRequestedSessionIdValid();
    }

    @Override
    public boolean isRequestedSessionIdFromCookie() {
        return super.isRequestedSessionIdFromCookie();
    }

    @Override
    public boolean isRequestedSessionIdFromURL() {
        return super.isRequestedSessionIdFromURL();
    }

    @Override
    public boolean isRequestedSessionIdFromUrl() {
        return super.isRequestedSessionIdFromUrl();
    }

    @Override
    public boolean authenticate(HttpServletResponse response) throws IOException, ServletException {
        return super.authenticate(response);
    }

    @Override
    public void login(String username, String password) throws ServletException {
        super.login(username, password);
    }

    @Override
    public void logout() throws ServletException {
        super.logout();
    }

    @Override
    public Collection<Part> getParts() throws IOException, ServletException {
        return super.getParts();
    }

    @Override
    public Part getPart(String name) throws IOException, ServletException {
        return super.getPart(name);
    }

    @Override
    public <T extends HttpUpgradeHandler> T upgrade(Class<T> httpUpgradeHandlerClass) throws IOException, ServletException {
        return super.upgrade(httpUpgradeHandlerClass);
    }

    @Override
    public PushBuilder newPushBuilder() {
        return super.newPushBuilder();
    }

    @Override
    public Map<String, String> getTrailerFields() {
        return super.getTrailerFields();
    }

    @Override
    public boolean isTrailerFieldsReady() {
        return super.isTrailerFieldsReady();
    }
}
