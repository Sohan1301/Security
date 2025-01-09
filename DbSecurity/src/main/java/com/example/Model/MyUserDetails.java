package com.example.Model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {

	
	private Users user;
	
	public MyUserDetails(Users user) {
		
		this.user=user;
		
		// TODO Auto-generated constructor stub
	}

	

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Correct usage of Collections.singleton
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}
	

}
