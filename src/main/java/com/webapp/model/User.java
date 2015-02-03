package com.webapp.model;

import javax.persistence.Entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;


@Entity
public class User {
	private String name;
	private int age;
	
	public User(){
		
	}
	
	public User(String name, int age){
		this.name = name ;
		this.age = age;
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
