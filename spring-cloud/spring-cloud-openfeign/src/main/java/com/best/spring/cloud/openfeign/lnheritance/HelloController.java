package com.best.spring.cloud.openfeign.lnheritance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lnsane
 */
@RestController
public class HelloController implements Hello {
    @Autowired
    private Hello2Feign hello2Feign;
    @Autowired
    private HttpServletRequest request;

    @Override
    public void hello() {
        System.out.println(request);
        if (1 / 0 == 0) {

        }
    }

    @GetMapping("/123")
    public void one(HttpServletRequest httpServletRequest) {
        System.out.println(request);
        System.out.println(httpServletRequest);
        System.out.println("123");
    }

}
