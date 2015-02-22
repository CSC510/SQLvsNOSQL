package com.webapp.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.webapp.model.House;
import com.webapp.service.HouseService;

@Controller
public class HouseAction {
	@Resource
	private HouseService houseService;
	
	public void addHouse(House house) {
		houseService.addHouse(house);
	}
	
	public List<House> findHouseByName(String name) {
		List<House> houses = houseService.findHouseByName(name);
		return houses;
	}
	
	public void deleteHouseByName(String name) {
		houseService.deleteHouseByName(name);
	}
	
}
