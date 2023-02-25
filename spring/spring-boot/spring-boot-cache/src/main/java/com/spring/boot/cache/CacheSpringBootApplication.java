package com.spring.boot.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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
    @Lazy
    private CacheSpringBootApplication cacheSpringBootApplication;
    @Autowired
    private CacheManager cacheManager;

    public class User {
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
        cacheSpringBootApplication.mewUserBean(user);
        return "";
    }

    @GetMapping("/user/{id}")
    @Cacheable(value = "user",key = "#id")
    public User newUser2(@PathVariable("id") String id){
        Cache cache = cacheManager.getCache("user");
        Cache.ValueWrapper valueWrapper = Optional.ofNullable(cache).map(cache1 -> cache1.get("1")).orElse(null);
        Object o = valueWrapper.get();
        System.out.println(o);

        System.out.println();
        return null;
    }

    @Cacheable(value = "user",key = "#user.id")
    public User mewUserBean(User user) {
        return user;
    }
}
