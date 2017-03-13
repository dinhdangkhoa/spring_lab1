package com.polytech.repository;

import com.polytech.business.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KHOA on 13-Mar-17.
 */
public class PostRepositoryImpl implements PostRepository{

    List<Post> posts = new ArrayList<Post>();

    public void save(Post post) {
        posts.add(post);
    }

    public List<Post> findAll() {
        return posts;
    }
}
