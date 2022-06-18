package com.example.UserRegistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.UserRegistration.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}

