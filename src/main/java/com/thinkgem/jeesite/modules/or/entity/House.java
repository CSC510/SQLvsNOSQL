/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.thinkgem.jeesite.modules.or.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.IdEntity;

/**
 * houseEntity
 * @author ThinkGem
 * @version 2015-02-19
 */
@Entity
@Table(name = "or_house")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class House extends IdEntity<House> {
	
	private final int RESIDENCE_HALL = 1;
	private final int GENERAL_APARTMENT = 2;
	private final int FAMILY_APARTMENT = 3;
	
	private static final long serialVersionUID = 1L;
	private String name; 	// 名称
	private String address;
	private String telephone;
	private int houseType;
	private int rooms;
	private List<Room> rentRooms;
	
	private int baths;
	private int rate;
	private String rentStatus;
	

	public House() {
		super();
	}

	public House(String id){
		this();
		this.id = id;
	}
	 
	@Length(min=1, max=200)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getHouseType() {
		return houseType;
	}

	public void setHouseType(int houseType) {
		this.houseType = houseType;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}
	
    @OneToMany(mappedBy="house")
	public List<Room> getRentRooms() {
		return rentRooms;
	}

	public void setRentRooms(List<Room> rentRooms) {
		this.rentRooms = rentRooms;
	}

	public int getBaths() {
		return baths;
	}

	public void setBaths(int baths) {
		this.baths = baths;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getRentStatus() {
		return rentStatus;
	}

	public void setRentStatus(String rentStatus) {
		this.rentStatus = rentStatus;
	}
	
}


