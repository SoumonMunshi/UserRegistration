package com.example.UserRegistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.UserRegistration.entity.User;
import com.example.UserRegistration.entity.UserDetails;
import com.example.UserRegistration.repository.UserRepository;

@Service
public class UserDetailsService {

	@Autowired
    private UserRepository userRepo;
	
	public List<User> listAll() {
        return userRepo.findAll();
    }
     
    public void save(User user) {
    	userRepo.save(user);
    }
     
    public User get(long id) {
        return userRepo.findById(id).get();
    }
     
    public void delete(long id) {
    	userRepo.deleteById(id);
    }
}