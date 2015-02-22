package com.webapp.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.webapp.model.House;
import com.webapp.model.Request;
import com.webapp.model.User;
import com.webapp.service.HouseService;
import com.webapp.service.RequestService;
import com.webapp.service.UserService;

public class RentAction {
	@Autowired
	private RequestService requestService;
	private int studentId;
	private String userName;
	private String houseType;
	public String execute(){
		User user=new User();
		user.setName(userName);
		user.setStudentId(studentId);
		List<House> houses=requestService.findHouse(houseType);
		if (houses==null) {
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
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
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
