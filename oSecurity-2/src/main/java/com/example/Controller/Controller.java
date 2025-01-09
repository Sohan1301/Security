package com.example.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

/*
 * @CrossOrigin("*")
 */

/* @RequestMapping("/hello") */
@RestController
public class Controller {


	
	@GetMapping("/")
	public String getmsg1(HttpServletRequest request) {
		return "hello hyderabad"+ request.getSession().getId();
	}
	

	/*
	 * @GetMapping("/big") public String getmsg2() { return "hello Security"; }
	 */
	
	
}
