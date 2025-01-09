package com.example.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Configsecure {

	@Bean
	public SecurityFilterChain securityfilterchain(HttpSecurity security) throws Exception {
	  
		 security.csrf(Customizer ->Customizer.disable());       //unabling csrf
		       security.authorizeHttpRequests(request ->request.anyRequest().authenticated());
				/*
				 * security.formLogin(Customizer.withDefaults());
				 */		      
		       security.httpBasic(Customizer.withDefaults());
		       security.sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		       return security.build();
	}
	/*
	 * @Bean public UserDetailsService userDeatILSSERVICE() { UserDetails USER1=User
	 * .withDefaultPasswordEncoder() .username("sohan") .password("sohan234")
	 * .roles("admin") .build();
	 * 
	 * 
	 * return new InMemoryUserDetailsManager(USER1);
	 * 
	 * }
	 */
	
	
	
	
}
