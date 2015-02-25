package com.thinkgem.jeesite.modules.or.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.thinkgem.jeesite.common.persistence.IdEntity;

@Entity
@Table(name = "or_room")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Room extends IdEntity<Room>{
	private House house;
	private int rate;
	private String placeNumber;
	private String roomNumber;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH},fetch = FetchType.LAZY)
	@JoinColumn(name="house_id")
	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
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
	
	
}
