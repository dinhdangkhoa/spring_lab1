package com.polytech.view;

import com.polytech.business.Post;
import com.polytech.business.PublicationService;
import com.polytech.config.ApplicationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Created by KHOA on 13-Mar-17.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        PublicationService publicationService = applicationContext.getBean(PublicationService.class);
        publicationService.post(new Post("Hello Spring"));
        List<Post> postList = publicationService.fetchAll();
        System.out.println(postList);
    }
}
