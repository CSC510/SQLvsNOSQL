package com.webapp.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.common.persistence.Parameter;
import com.webapp.dao.HouseDao;
import com.webapp.model.House;

@Service
@Transactional(readOnly =true)
public class HouseService {
	@Resource(name="houseMDBImpl")
	private HouseDao houseDao;

	
	public House get(int id){
		return houseDao.findById(id);
	}
	
	/**
	 * Using Parameter to support multiple query condition
	 * translate parameter to sql query:
	 *  parameter[name]={"like","'%house.name%'"} => name like '%house.name%' 
	 *  parameter[type]=house.type => where type='house.type' 
	 * @param page
	 * @param house
	 * @return
	 */
	public List<House> find( House house){
		String sqlstr = "select * from house";
		Parameter parameter = new Parameter();
		if(StringUtils.isNotBlank(house.getName())){
			parameter.put("name", house.getName());
		}
		if(StringUtils.isNotBlank(house.getType())){
			parameter.put("type", house.getType());
		}
		
		return houseDao.findAll(sqlstr, parameter);
		
	}

	public void save(House house){
		houseDao.save(house);
	}

	public void delete(House house){
		houseDao.deleteById(house.getId());
	}	
}
