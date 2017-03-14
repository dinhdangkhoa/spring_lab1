package com.polytech.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * Created by KHOA on 14-Mar-17.
 */
@Configuration
@PropertySource("classpath:/application.properties")
public class InfracstructureConfig {
//    @Value("$(datasource.driverName)")
//    private String driverClassName;
//
//    @Value("$(datasource.url)")
//    private String url;
//
//    @Value("$(datasource.username)")
//    private String username;
//
//    @Value("$(datasource.password")
//    private String password;
//
//    @Bean
//    public DataSource dataSource(){
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        dataSource.setUrl(url);
//        dataSource.setDriverClassName(driverClassName);
//        return dataSource;
//    }
}
