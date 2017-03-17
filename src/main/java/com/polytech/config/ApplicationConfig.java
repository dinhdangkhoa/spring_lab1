package com.polytech.config;

import com.polytech.business.PublicationService;
import com.polytech.business.PublicationServiceImpl;
import com.polytech.repository.JdbcPostRepository;
import com.polytech.repository.PostRepository;
import com.polytech.view.PostController;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Created by KHOA on 13-Mar-17.
 */

@Configuration
//@ComponentScan(basePackages = "com.polytech")
@Import(InfracstructureConfig.class)

public class ApplicationConfig {
    @Autowired
    private Environment environment;

    @Bean(name = "dataSource")
    @Profile("DEV")
    public DataSource devDataSource(){
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScripts("create-schema.sql")
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
    @Bean
    public PostRepository postRepository(DataSource dataSource){
        return  new JdbcPostRepository(dataSource);
    }

    @Bean
    public PublicationService publicationService(PostRepository postRepository){
        return new PublicationServiceImpl(postRepository);
    }
    @Bean
    public PostController postController(PublicationService publicationService){
        return new PostController(publicationService);
    }
}
