package com.polytech.business;

import java.util.List;

/*Created by KHOA on 17-Mar-17*/

public interface UserService {
    void save(User user);
    public User findByUsername(String username);
    List<User> findAll();
}
