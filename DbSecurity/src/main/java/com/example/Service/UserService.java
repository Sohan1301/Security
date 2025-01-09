package com.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Model.Users;
import com.example.Repo.UserRepo;
@Service
public class UserService {

	@Autowired
	private UserRepo repo;
	@Autowired
  private AuthenticationManager authManager;
	
	@Autowired 
	private JwtService jwt;
	
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    
    
	public Users register(Users user) {
		
      user.setPassword(encoder.encode(user.getPassword()));
	return repo.save(user);
	
	}


	public String verify(Users user) {
		Authentication auth=authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
		if(auth.isAuthenticated()) 
			return jwt.generateToken((user.getUsername()));
		
		
		
			return "fail";
	}
	
}
