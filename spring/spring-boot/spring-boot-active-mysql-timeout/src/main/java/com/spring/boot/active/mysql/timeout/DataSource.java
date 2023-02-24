package com.spring.boot.active.mysql.timeout;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author CunLu Wang
 * @since 2023/2/17
 */

public class DataSource {

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
        config.setJdbcUrl( "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8" );
        config.setUsername( "root" );
        config.setPassword( "123456" );
        config.setIdleTimeout(30000);
        config.setMinimumIdle(1);
        config.setMaximumPoolSize(1);
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        ds = new HikariDataSource( config );
    }

    private DataSource() {}

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
