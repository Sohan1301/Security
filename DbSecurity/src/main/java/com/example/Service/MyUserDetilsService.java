package com.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Model.MyUserDetails;
import com.example.Model.Users;
import com.example.Repo.UserRepo;
@Service
public class MyUserDetilsService  implements UserDetailsService{
      
	@Autowired
	private UserRepo repo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
           Users user=repo.findByUsername(username);	
           System.out.println(user);
          if(user==null) {
        	  System.out.println("usernotfound");
        	  throw new UsernameNotFoundException("users not found");
          }
          
		return new MyUserDetails(user);
	}
	

}
