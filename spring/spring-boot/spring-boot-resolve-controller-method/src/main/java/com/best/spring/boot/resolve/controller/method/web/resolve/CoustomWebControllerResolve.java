package com.best.spring.boot.resolve.controller.method.web.resolve;

import com.best.spring.boot.resolve.controller.method.controller.User;
import java.lang.reflect.Parameter;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author lnsane
 */
public class CoustomWebControllerResolve implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        Parameter parameter1 = parameter.getParameter();
        if (parameter1.getType().equals(User.class)) {
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        User user  = new User();
        user.setUserName("root");
        return user;
    }
}
