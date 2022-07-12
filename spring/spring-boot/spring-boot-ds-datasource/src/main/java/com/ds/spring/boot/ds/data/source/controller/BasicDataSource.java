package com.ds.spring.boot.ds.data.source.controller;

import lombok.Data;

@Data
public class BasicDataSource {
    private String url;
    private String username;
    private String password;
    private String driverClassName;
}
