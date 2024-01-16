package com.realtime.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realtime.blogapp.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
      Role findByName(String name);
}  