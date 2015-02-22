package com.webapp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.webapp.dao.HouseDao;
import com.webapp.model.House;
@Component
public class HouseService {
	@Resource(name = "houseMDBImpl")
	private HouseDao houseDao;
	public HouseService() {
		
	}
	public void addHouse(House house){
		houseDao.save(house);
	}
	public List<House>findHousesByType(String typeString){
		return houseDao.findByType(typeString);
	}
}
