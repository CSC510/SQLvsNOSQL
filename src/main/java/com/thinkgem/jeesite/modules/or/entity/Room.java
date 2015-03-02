/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.thinkgem.jeesite.modules.or.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.apache.ibatis.annotations.One;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.IdEntity;

/**
 * roomEntity
 * @author Jentle
 * @version 2015-02-26
 */
@Entity
@Table(name = "or_room")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Room extends IdEntity<Room> {
	
	public static final String  AVAILABLE = "available";
	public static final String  WAITED = "waited";
	public static final String  RESERVED  = "reserved";
	public static final String  RENTED = "rented";
	
	public static final int MAX_APPLICATIONS = 3;
	private static final long serialVersionUID = 1L;	
	
	private int monthRate;
	private String placeNumber;
	private String roomNumber;
	private String rentStatus;
	private House house;
	
	private int applications;
	
	public Room() {
		super();
	}

	public Room(String id){
		this();
		this.id = id;
	}
	 
	public Room(House house){
		this.house = house;
	}
	
	@ManyToOne
	@JoinColumn(name="house_id")
	public House getHouse() {
		return house;
	}

	
	public void setHouse(House house) {
		this.house = house;
	}
	
	@Transient
	public int getHouseType(){
		return this.house.getHouseType();
	}
	public int getMonthRate() {
		return monthRate;
	}

	public void setMonthRate(int monthRate) {
		this.monthRate = monthRate;
	}

	public String getPlaceNumber() {
		return placeNumber;
	}

	public void setPlaceNumber(String placeNumber) {
		this.placeNumber = placeNumber;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRentStatus() {
		return rentStatus;
	}

	public void setRentStatus(String rentStatus) {
		this.rentStatus = rentStatus;
	}
	
	public int getApplications(){
		return applications;
	}
	
	public void setApplications(int applications){
		this.applications = applications;
	}

	public void changeStatus( int Add_Or_Reduce){
		int applicationSize = this.applications + Add_Or_Reduce;
		if(applicationSize==0){
			this.rentStatus= Room.AVAILABLE;
		}else if(applicationSize < Room.MAX_APPLICATIONS){
			this.rentStatus  = Room.WAITED;
		}else{
			this.rentStatus = Room.RESERVED;
		}
		this.applications  = applicationSize;
	}
}


