package com.example.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecureConfig {

	@Autowired
	public UserDetailsService userDetailsService;
	@Autowired 
	private JwtFilter jwtFilter;
      
	@Bean
	public SecurityFilterChain securityfilterchain(HttpSecurity security) throws Exception {

		security.csrf(Customizer -> Customizer.disable()); // unabling csrf
		security.authorizeHttpRequests(request -> request.requestMatchers("/signup","/login").permitAll().anyRequest().authenticated());
		

		security.httpBasic(Customizer.withDefaults());
		security.addFilterBefore(jwtFilter ,UsernamePasswordAuthenticationFilter.class );


        security.sessionManagement(management -> management
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)) ;
		return security.build();
	}

    @Bean
    public AuthenticationProvider authenticationProvider() {
    	
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
       
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        // Ensure encoding is consistent
        provider.setUserDetailsService(userDetailsService);
        return provider;
	}
    @Bean
    @slf4j
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
    

}
