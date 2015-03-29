package com.webapp.daoimpl.mdb;


import java.util.List;

import org.springframework.stereotype.Component;

import com.webapp.common.persistence.Parameter;
import com.webapp.dao.HouseDao;
import com.webapp.model.House;
@Component
public class HouseMDBImpl extends BaseMDBImpl<House> implements HouseDao{

	@Override
	public List<House> findByType(String type) {
		Parameter parameter = new Parameter();
		parameter.put("type", type);
		return findAll(parameter);
	}



	
}
