package com.realtime.blogapp.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.realtime.blogapp.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
      Optional<Post> findByUrl(String url);

      @Query("SELECT p from Post p WHERE " +
                  " p.title LIKE CONCAT('%', :query, '%') OR " +
                  " p.shortDescription LIKE CONCAT('%', :query, '%')")
      List<Post> searchPosts(String query);
}
