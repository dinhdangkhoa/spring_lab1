package com.polytech.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Created by KHOA on 13-Mar-17.
 */

@Configuration
@PropertySource("classpath:/application.properties")
@ComponentScan(basePackages = "com.polytech")
@EntityScan(basePackages = "com.polytech.business")
@EnableJpaRepositories("com.polytech.repository")
public class ApplicationConfig {
    @Autowired
    private Environment environment;

    @Bean(name = "dataSource")
    @Profile("DEV")
    public DataSource devDataSource(){
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScripts("create-schema.sql")
                .addScripts("default-user.sql")
                .build();
    }
    @Bean(name = "dataSource")
    @Profile("PROD")
    public DataSource prodDataSource(){
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
    }

}
