package com.webapp.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.webapp.model.House;
import com.webapp.model.Request;
import com.webapp.model.User;
import com.webapp.service.RequestService;

@Controller
public class RentAction {
	@Autowired
	private RequestService requestService;
	private String userName;
	private String houseType;
	public String execute(){
		User user=new User();
		user.setName(userName);
		List<House> houses=requestService.findHouse(houseType);
		if (houses.size()==0) {
			return "fail";
		}
		else {
			Request request=new Request();
			request.setHouse(houses.get(0));
			request.setUser(user);
			requestService.saveRequest(request);
			return "success";
		}
	}
	//getter and setter
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getHouseType() {
		return houseType;
	}
	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}
	
}
