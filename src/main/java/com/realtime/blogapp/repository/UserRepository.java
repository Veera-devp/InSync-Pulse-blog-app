package com.realtime.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realtime.blogapp.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
      User findByEmail(String email);

      
}  