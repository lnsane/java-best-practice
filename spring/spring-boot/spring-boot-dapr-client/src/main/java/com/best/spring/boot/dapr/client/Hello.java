package com.best.spring.boot.dapr.client;

import lombok.Data;

import java.io.Serializable;

/**
 * @author CunLu Wang
 * @since 2022/7/27
 */
@Data
public class Hello implements Serializable {
    public static final long serialVersionUID = 42L;
    private String hello;
    private String world;
}
