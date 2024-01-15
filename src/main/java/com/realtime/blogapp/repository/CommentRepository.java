package com.realtime.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realtime.blogapp.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long>{
      
}
