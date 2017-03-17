package com.polytech.repository;

import com.polytech.business.Post;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by KHOA on 13-Mar-17.
 */
//@Component
@Repository
@Transactional
public class JpaPostRepository implements PostRepository{

    @PersistenceContext
    public EntityManager entityManager;

    public JpaPostRepository(){

    }

    public void save(Post post) {
        entityManager.persist(post);
    }

    public List<Post> findAll() {
        //recupere des objets
        Query query =  entityManager.createQuery("SELECT p FROM Post p");
        return query.getResultList();
    }
}
