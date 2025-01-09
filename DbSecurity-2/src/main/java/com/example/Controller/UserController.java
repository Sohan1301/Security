package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Pojo.Users;
import com.example.Service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService service;


    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        return service.register(user);

    }
    @GetMapping("/hi")
    public String get() {
    	return "hello world";
    }
    
    @PostMapping("/login")
    	public String login(@RequestBody Users user) {
    	return "success";
    }
}
