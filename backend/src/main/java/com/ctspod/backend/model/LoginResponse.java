package com.ctspod.backend.model;

import java.io.Serializable;

public class LoginResponse implements Serializable {
  
	
	final String jwt;
	String username;
	
	public LoginResponse(String jwt, String username) {
		super();
		this.jwt = jwt;
		this.username=username;
	}
	 
	public String getJwt() {
		return jwt;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username=username;
	}

	}
