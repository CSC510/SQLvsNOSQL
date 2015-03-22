package com.webapp.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

@MappedSuperclass
public abstract class IdEntity<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	protected String id;
	
	public IdEntity() {
		super();
	}
	
	@PrePersist
	public void prePersist(){
		this.id =UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	@Id
	public String getId(){
		return this.id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
}
