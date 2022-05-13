package com.example.Spring_Boot_JDBC.springConfig;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class springconfig {

    @Value("${spring.datasource.url}")
    private String username;
    @Value("${spring.datasource.username}")
    private String password;
    @Value("${spring.datasource.driver-class-name}")
    private String driver;
    @Value("${spring.datasource.url}")
    private String url;

    public HikariDataSource getData(){

        HikariConfig config=new HikariConfig();
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName(driver);
        config.setJdbcUrl(url);

        HikariDataSource dataSource=new HikariDataSource(config);

        if(dataSource.isRunning()){
            System.out.println("--------->connection established successfully");
        }
        return dataSource;

    }

    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate=new JdbcTemplate(getData());
        return jdbcTemplate;
    }
}
