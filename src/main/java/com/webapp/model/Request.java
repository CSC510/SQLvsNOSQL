package com.webapp.model;

import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Request extends IdEntity<Request> {
	private User user;
	private House house;
	public Request() {
		// TODO Auto-generated constructor stub
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	
	
	
	
}
