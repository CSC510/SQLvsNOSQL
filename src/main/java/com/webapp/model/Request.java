package com.webapp.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.data.mongodb.core.mapping.Document;


@Entity
public class Request extends IdEntity<Request> {
	private User user;
	private House house;
	private String comment;
	public Request() {
		
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinTable(name = "house_request", joinColumns = { @JoinColumn(name = "request_id") }, inverseJoinColumns = { @JoinColumn(name = "house_id") })
	public House getHouse() {
		return house;
	}
	
	public void setHouse(House house) {
		this.house = house;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
		
}
