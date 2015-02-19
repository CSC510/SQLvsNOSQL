package com.webapp.model;


import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class House extends IdEntity<House> {
	
	private String name;
    
	@Indexed(unique = true)
	private int houseId;
	private String type;
	public House(){
		
	}
	
	public House(String name,int hid){
		this.name = name ;
		this.houseId=hid;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public int getHouseId() {
		return houseId;
	}

	public void setHouseId(int houseId) {
		this.houseId = houseId;
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
