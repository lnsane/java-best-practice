package com.best.spring.cloud.openfeign.bean;

import java.io.Serializable;

/**
 * @author CunLu Wang
 * @since 2023/5/24
 */
public class User<T> implements Serializable {
    public T getUsername() {
        return username;
    }

    public void setUsername(T username) {
        this.username = username;
    }

    private T username;
}
