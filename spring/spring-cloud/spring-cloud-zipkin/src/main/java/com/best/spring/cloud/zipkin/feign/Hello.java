package com.best.spring.cloud.zipkin.feign;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author lnsane
 */
public interface Hello {

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    void hello();

}
