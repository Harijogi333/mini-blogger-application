package com.blog.mini_blogger_app.repository;

import com.blog.mini_blogger_app.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

}
