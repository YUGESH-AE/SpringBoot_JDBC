package com.example.Spring_Boot_JDBC.springConfig;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

@Configuration
@SuppressWarnings("all")
public class springconfig {

    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driver-class-name}")
    private String driver;
    @Value("${spring.datasource.url}")
    private String url;

    @Bean
    public HikariDataSource getHikariDataSource(){

        HikariConfig hikariConfig=new HikariConfig();
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        hikariConfig.setDriverClassName(driver);
        hikariConfig.setJdbcUrl(url);

        HikariDataSource dataSource=new HikariDataSource(hikariConfig);

        if(dataSource.isRunning()){
            System.out.println("--------->connection established successfully");
        }
        return dataSource;

    }

    @Bean

    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate=new JdbcTemplate(getHikariDataSource());
        return jdbcTemplate;
    }
    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(){
       NamedParameterJdbcTemplate namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(getHikariDataSource());
        return namedParameterJdbcTemplate;
    }

    @Bean
    public SimpleJdbcCall simpleJdbcCall(){
        SimpleJdbcCall simpleJdbcCall=new SimpleJdbcCall(getHikariDataSource());
        return simpleJdbcCall;
    }
}
