package com.webapp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.webapp.dao.HouseDao;
import com.webapp.dao.RequestDao;
import com.webapp.dao.UserDao;
import com.webapp.model.House;
import com.webapp.model.Request;
import com.webapp.model.User;
@Component
public class RequestService {
	@Resource(name = "requestMDBImpl")
	private RequestDao requestDao;
	@Resource(name="userMDBImpl")
	private UserDao userDao;
	@Resource(name="houseMDBImpl")
	private HouseDao houseDao;
	public RequestService() {
		// TODO Auto-generated constructor stub
	}
	public void saveRequest(Request request){
		requestDao.save(request);
	}
	public List<House> findHouse(String str){
		return houseDao.findByType(str);
	}
	public void saveUser(User user){
		userDao.save(user);
	}
	public void saveHouse(House house){
		houseDao.save(house);
	}
	//Need to modify!!!
	public User getUser(String nameString){
		return userDao.findByName(nameString).get(0);
	}
	
}
