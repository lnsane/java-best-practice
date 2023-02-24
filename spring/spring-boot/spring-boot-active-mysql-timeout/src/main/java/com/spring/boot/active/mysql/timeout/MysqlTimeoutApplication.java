package com.spring.boot.active.mysql.timeout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

/**
 * @author CunLu Wang
 * @since 2023/2/17
 */
@SpringBootApplication
@EnableAsync
@RequestMapping
@RestController
public class MysqlTimeoutApplication {
    public static void main(String[] args) {
        SpringApplication.run(MysqlTimeoutApplication.class,args);
    }

    @GetMapping
    public void run () throws SQLException {
        String SQL_QUERY = "SHOW SESSION VARIABLES LIKE '%wait_timeout%'";
        try (Connection con = DataSource.getConnection()) {
            while (true) {
                TimeUnit.SECONDS.sleep(31);
                PreparedStatement pst = con.prepareStatement( SQL_QUERY );
                ResultSet rs = pst.executeQuery();
                System.out.println(rs);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
