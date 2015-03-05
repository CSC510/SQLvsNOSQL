package com.webapp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.webapp.dao.HouseDao;
import com.webapp.daoimpl.mdb.Parameter;
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
	public List<House> findHousesByType(String type){
		return houseDao.findByType(type);
	}
	public List<House> findHouseByName(String name) {
		Parameter parameter = new Parameter();
		parameter.put("name", name);
		return houseDao.findAll(parameter);
	}
	public void deleteHouseByName(String name) {
		Parameter parameter = new Parameter();
		parameter.put("name", name);
		List<House> houses = houseDao.findAll(parameter);
		
		for(House house: houses) {
			houseDao.delete(house);
		}
	}
}
