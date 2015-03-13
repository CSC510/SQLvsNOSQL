package com.webapp.model;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class IdEntity<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected int id;
	
	public IdEntity() {
		super();
	}
	
	@Id
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
}
