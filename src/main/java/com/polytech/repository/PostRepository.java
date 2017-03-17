package com.polytech.repository;

import com.polytech.business.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by KHOA on 13-Mar-17.
 */
public interface PostRepository /*extends JpaRepository<Long,Post>*/ {
    void save(Post post);
    List<Post> findAll();
}
