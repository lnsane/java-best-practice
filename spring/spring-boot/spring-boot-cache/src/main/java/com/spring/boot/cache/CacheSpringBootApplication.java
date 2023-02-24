package com.spring.boot.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CunLu Wang
 * @since 2023/2/24
 */
@SpringBootApplication
@EnableCaching
@RestController
@RequestMapping
public class CacheSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(CacheSpringBootApplication.class,args);
    }

    @Autowired
    private CacheManager cacheManager;

    class User {
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        private String id;
        private String username;
    }

    @GetMapping("/hello")
    public String newUser(){
        User user = new User();
        user.setId("1");
        user.setUsername("2");
        mewUserBean(user);
        return "";
    }

    @GetMapping("/user")
    public String newUser2(){
        Cache cache = cacheManager.getCache("1");
        System.out.println(cache.get("1"));
        return "1";
    }

    @Cacheable(value = "{user}",key = "{user.id}")
    public void mewUserBean(User user) {
        System.out.println(user);
    }
}
