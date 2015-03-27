package com.webapp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;


@Entity
public class House extends IdEntity<House> {
	
	private String name;
    
	private String type;
	private List<Request> requestList;
	
	@OneToMany(mappedBy ="house")
	public List<Request> getRequestList() {
		return requestList;
	}

	public void setRequestList(List<Request> requestList) {
		this.requestList = requestList;
	}

	public House(){
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString(){
		return name;
	}
	
}
