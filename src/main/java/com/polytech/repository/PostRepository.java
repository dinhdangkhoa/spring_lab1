package com.polytech.repository;

import com.polytech.business.Post;

import java.util.List;

/**
 * Created by KHOA on 13-Mar-17.
 */
public interface PostRepository {
    void save(Post post);
    List<Post> findAll();
}
