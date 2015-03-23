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
	
	
	
	public List<House> findHouseByName(House house) {
		List<House> houses = houseService.find( house);
		return houses;
	}
	
	public void save(House house) {
		houseService.save(house);
	}
	public void delete(House house) {
		houseService.delete(house);
	}
	
}
