package com.featuresector.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.featuresector.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);

}
