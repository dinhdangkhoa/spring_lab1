package com.polytech.business;

import com.polytech.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by KHOA on 13-Apr-17.
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public void comment(String content, String username, long postid) {
        Query q = entityManager.createNativeQuery("INSERT INTO COMMENT (CONTENT,POST_ID,USERNAME) VALUES (?1,?2,?3)");
        q.setParameter(1,content);
        q.setParameter(2,postid);
        q.setParameter(3,username);
        q.executeUpdate();
    }

    @Override
    public List<Comment> fetchAll(Long idPost) {
        TypedQuery query =  entityManager.createNamedQuery("Comment.findByPostID",commentuser.class);
        query.setParameter("post",idPost);
        return query.getResultList();
    }
}
