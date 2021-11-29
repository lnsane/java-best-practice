package com.best.spring.boot.jetcache;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CreateCache;
import org.springframework.stereotype.Component;

/**
 * @author lnsane
 */
@Component
public class ApiCache {
    @CreateCache(name = "user::cache:", expire = -1)
    private Cache<String, User> userCache;

    public void setUser(String key, User user) {
        userCache.put(key, user);
    }

    public User getUser(String key) {
        return userCache.get(key);
    }
}
