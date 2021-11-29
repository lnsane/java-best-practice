package com.best.spring.boot.jetcache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lnsane
 */
@RestController
public class HelloController {

    private final static Logger log = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private ApiCache apiCache;

    @PostMapping
    public void hello() {
        User user= new User();
        user.setUserName("root1");
        user.setAge(23);
        apiCache.setUser("root1",user);
    }

    @GetMapping
    public void helloQuery(){
        User root = apiCache.getUser("root1");
        log.info(root.toString());
    }
}
