package com.polytech.repository;

import com.polytech.business.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by KHOA on 17-Mar-17.
 */
public interface UserRepository extends JpaRepository<User, String>{
     User findByUsername(String username);

}
