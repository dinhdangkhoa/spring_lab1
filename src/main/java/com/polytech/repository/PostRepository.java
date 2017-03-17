package com.polytech.repository;

import com.polytech.business.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by KHOA on 13-Mar-17.
 */
@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

}
