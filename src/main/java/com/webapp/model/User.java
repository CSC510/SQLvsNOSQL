package com.webapp.model;

import javax.persistence.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Entity
public class User extends IdEntity<User> {
	
	private String name;
 
	
	public User(){
		
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString(){
		return name;
	}
}
