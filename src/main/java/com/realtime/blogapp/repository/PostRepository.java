package com.realtime.blogapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realtime.blogapp.entity.Post;

public interface PostRepository extends JpaRepository<Post,Long>{
      Optional<Post> findByUrl(String url);
}
