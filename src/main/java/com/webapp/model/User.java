package com.webapp.model;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class User extends IdEntity<User> {
	
	private String name;
    
	@Indexed(unique = true)
	private int studentId;
	
	public User(){
		
	}
	
	public User(String name,int sid){
		this.name = name ;
		this.studentId=sid;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
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
