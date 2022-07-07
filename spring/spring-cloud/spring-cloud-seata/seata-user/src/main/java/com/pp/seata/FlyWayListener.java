package com.pp.seata;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

public class FlyWayListener implements ApplicationListener<ApplicationStartedEvent> {

    Logger log = new LoggerContext().getLogger(FlyWayListener.class);
    @Value("${spring.datasource.database-address}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.database-name}")
    private String databaseName;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {

    }

}