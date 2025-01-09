package com.example.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users {
@Id
private int id;
private String username;
private String password;
public Users() {
	super();
	// TODO Auto-generated constructor stub
}
public Users(int id, String username, String password) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
}
public int getId() {
	return id;
}
public String getUsername() {
	return username;
}
public String getPassword() {
	return password;
}
public void setId(int id) {
	this.id = id;
}
public void setUsername(String username) {
	this.username = username;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "Users [id=" + id + ", username=" + username + ", password=" + password + "]";
}


	
	
}
