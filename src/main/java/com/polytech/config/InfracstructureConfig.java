package com.polytech.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Created by KHOA on 14-Mar-17.
 */
@Configuration
@PropertySource("classpath:/application.properties")
public class InfracstructureConfig {

    @Autowired
    private Environment environment;
/*

    @Value("${datasource.driverName}")
    private String driverClassName;

    @Value("${datasource.url}")
    private String url;

    @Value("${datasource.username}")
    private String username;

    @Value("${datasource.password}")
    private String password;
*/

//    @Bean(name = "dataSource")
//    @Profile("PROD")
    /*public DataSource dataSource(){
        String username = environment.getProperty("datasource.username");
        String password = environment.getProperty("datasource.password");
        String url = environment.getProperty("datasource.url");
        String driverClassName = environment.getProperty("datasource.driverName");

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }*/

   /* @Bean(name = "dataSource")
    @Profile("DEV")
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScripts("create-schema.sql")
                .build();
    }*/

}
