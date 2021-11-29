package com.best.spring.boot.jetcache;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lnsane
 */
@SpringBootApplication
@EnableCreateCacheAnnotation
@EnableMethodCache(basePackages = "com.best.spring.boot.jetcache")
public class SpringBootJeCacheDemo {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootJeCacheDemo.class,args);
    }
}
