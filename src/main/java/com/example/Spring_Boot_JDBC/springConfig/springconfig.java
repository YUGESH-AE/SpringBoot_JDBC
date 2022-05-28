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

    @Bean

    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate=new JdbcTemplate(getData());
        return jdbcTemplate;
    }
    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(){
       NamedParameterJdbcTemplate namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(getData());
        return namedParameterJdbcTemplate;
    }

    @Bean
    public SimpleJdbcCall simpleJdbcCall(){
        SimpleJdbcCall simpleJdbcCall=new SimpleJdbcCall(getData());
        return simpleJdbcCall;
    }
}
