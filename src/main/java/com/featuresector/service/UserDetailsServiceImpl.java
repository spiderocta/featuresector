package com.featuresector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.featuresector.domain.User;
import com.featuresector.repositories.UserRepository;
import com.featuresector.security.CustomSecurityUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepo;
  
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepo.findByUsername(username);
    
    if (user == null)
      throw new UsernameNotFoundException("Invalid Username and password");
    
    return new CustomSecurityUser(user);
  }

}
