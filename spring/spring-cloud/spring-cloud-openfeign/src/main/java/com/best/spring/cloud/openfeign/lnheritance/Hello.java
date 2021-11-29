package com.best.spring.cloud.openfeign.lnheritance;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author lnsane
 */
public interface Hello {

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    void hello();

}
