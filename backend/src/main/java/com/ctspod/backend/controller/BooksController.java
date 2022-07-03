package com.ctspod.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class BooksController {
 
	@RequestMapping("/")                    //everyone
	public String homeMessage() {
		// return "<h1>home</h1>";  
        return "home"; 
	}
	
	@RequestMapping("/user")                //admin & user   
	public String userMessage() {
		//return "<h1>user</h1>"; 
        return "accesible demo  data for user";  
	}
	
	
	@RequestMapping("/admin")              //only admin   
	public String adminMessage() {
		//return "<h1>admin</h1>";  
        return "accesible demo  data only for admin"; 
	}
}
