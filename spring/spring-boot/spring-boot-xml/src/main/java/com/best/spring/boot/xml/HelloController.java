package com.best.spring.boot.xml;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 王存露
 */
@Controller
public class HelloController {
    @ResponseBody
    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public MyUser hello() {
        MyUser myUser = new MyUser();
        myUser.setUserName("wangcunlu");
        myUser.setAge("123");
        return myUser;
    }
}
