package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.Users;
import com.example.Service.UserService;

@RestController
public class UserController {
	  @Autowired
	public UserService service;
	  
	    BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
	    
	 @PostMapping("/signup")
	  public Users register(@RequestBody Users user) {
	      
		  return service.register(user);
	  }
	 @GetMapping("/hii")
	 public String getString() {
		 System.out.println("helloo");
		 return "hello world";
	 }
	 @PostMapping("/login")
 	public String login(@RequestBody Users user) {

		 return service.verify(user);
 	
 }
	 

	
}
