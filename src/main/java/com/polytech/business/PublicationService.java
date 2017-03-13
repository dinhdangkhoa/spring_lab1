package com.polytech.business;

import java.util.List;

/**
 * Created by KHOA on 13-Mar-17.
 */
public interface PublicationService {
    void post(Post post);
    List<Post> fetchAll();
}
