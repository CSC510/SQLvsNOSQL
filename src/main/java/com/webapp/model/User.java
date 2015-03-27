package com.webapp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.google.common.collect.Lists;

@Entity
public class User extends IdEntity<User> {
	
	private String name;
	private List<Request> requestList = Lists.newArrayList();
	
	public User(){
		
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	public List<Request> getRequestList(){
		return this.requestList;
	}
	
	public void setRequestList(List<Request> requestList){
		this.requestList = requestList;
	}
	
	@Override
	public String toString(){
		return name;
	}
}
