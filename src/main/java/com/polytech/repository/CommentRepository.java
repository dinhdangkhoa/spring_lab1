package com.polytech.repository;

import com.polytech.business.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by KHOA on 09-Apr-17.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment,Long>{

}
