package com.webapp.model;


import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class House extends IdEntity<House> {
	
	private String name;
    
	@Indexed(unique = true)
	private int houseId;
	
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

	@Override
	public String toString(){
		return name;
	}
	
}
