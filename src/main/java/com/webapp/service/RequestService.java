package com.webapp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.webapp.dao.HouseDao;
import com.webapp.dao.RequestDao;
import com.webapp.dao.UserDao;
import com.webapp.model.House;
import com.webapp.model.Request;
@Component
public class RequestService {
	@Resource(name = "requestMDBImpl")
	private RequestDao requestDao;
	private UserDao userDao;
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
	
}
