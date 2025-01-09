package com.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Pojo.Users;
import com.example.repo.UserRepo;

@Service
public class UserService {
	 @Autowired
	    private UserRepo repo;


	    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	    public Users register(Users user) {
	        user.setPassword(encoder.encode(user.getPassword()));
	        repo.save(user);
	        return user;
	    }
	
}
