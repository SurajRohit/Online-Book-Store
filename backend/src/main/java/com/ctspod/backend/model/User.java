package com.ctspod.backend.model;

import javax.persistence.Transient;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "userstable")
public class User {
 
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)  //generates auto id values
    private int id;
    private String username;
    private String password;
    @Transient                                       //this column will not be created in db table
    private boolean active;
    private String role="USER";            //default role will be USER if no "role" passed in JSON Response body
	
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String userName) {
		this.username = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}


}
