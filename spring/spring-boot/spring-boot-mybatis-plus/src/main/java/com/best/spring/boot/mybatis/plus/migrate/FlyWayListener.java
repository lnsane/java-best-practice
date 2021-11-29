package com.best.spring.boot.mybatis.plus.migrate;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
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
        try {
            this.migrate();
        } catch (SQLException e) {
            log.error("Failed to migrate database!", e);
        }
    }

    /**
     * Migrate database.
     */
    private void migrate() throws SQLException {
        log.info("Starting migrate database...");
        Flyway flyway = Flyway
                .configure()
                .schemas(databaseName)
                .table("flyway_migrate_history_of_demo")
                .locations("classpath:/migration")
                .baselineVersion("1")
                .baselineOnMigrate(true)
                .dataSource(url, username, password)
                .load();
        flyway.repair();
        flyway.migrate();
        log.info("Migrate database succeed.");
    }
}