package com.polytech.config;

import com.polytech.business.Comment;
import org.hibernate.jpa.internal.EntityManagerImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


/**
 * Created by KHOA on 16-Mar-17.
 */
@SpringBootApplication
public class ApplicationStarter {

    public static void main(String[] args) {
        System.setProperty("spring.profiles.active","DEV");
        SpringApplication.run(ApplicationStarter.class);
    }
}
