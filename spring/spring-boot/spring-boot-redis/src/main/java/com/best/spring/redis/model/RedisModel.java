package com.best.spring.redis.model;

import java.io.Serializable;

/**
 * @author 王存露
 */
public class RedisModel {
    private String id;

    private String userName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "RedisModel{" + "id='" + id + '\'' + ", userName='" + userName + '\'' + '}';
    }
}
