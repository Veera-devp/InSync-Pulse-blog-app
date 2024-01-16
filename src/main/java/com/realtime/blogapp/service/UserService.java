package com.realtime.blogapp.service;

import com.realtime.blogapp.dto.RegistrationDto;
import com.realtime.blogapp.entity.User;

public interface UserService {
      void saveUser(RegistrationDto registrationDto);
  
      User findByEmail(String email);
}
  
