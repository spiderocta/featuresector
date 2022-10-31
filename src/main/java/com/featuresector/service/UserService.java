package com.featuresector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.featuresector.domain.User;
import com.featuresector.repositories.UserRepository;
import com.featuresector.security.Authority;

@Service
public class UserService {
  
  @Autowired
  private UserRepository userRepo;
  
  @Autowired
  private PasswordEncoder passwordEncoder;
  
  public User save (User user) {
    String encodedPassword = passwordEncoder.encode(user.getPassword());
    user.setPassword(encodedPassword);
    
    Authority authority = new Authority();
    authority.setAuthority("ROLE_USER");
    authority.setUser(user);
    
    user.getAuthorities().add(authority);
    
    return userRepo.save(user);
  }
}
