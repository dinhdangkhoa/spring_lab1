package com.polytech.business;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by KHOA on 13-Apr-17.
 */

public interface CommentService {
    void comment(String content,String username, long postid);
    List<Comment> fetchAll(Long idPost);
}
