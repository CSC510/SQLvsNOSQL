package com.webapp.service;

import java.util.List;

import com.webapp.dao.HouseDao;
import com.webapp.model.House;

public class HouseService {
	private HouseDao houseDao;
	public void addHouse(House house){
		houseDao.save(house);
	}
	public List<House>findHousesByType(String typeString){
		return houseDao.findByType(typeString);
	}
}
