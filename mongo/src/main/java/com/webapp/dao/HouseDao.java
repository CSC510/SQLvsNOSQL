package com.webapp.dao;

import java.util.List;

import com.webapp.daoimpl.mdb.Parameter;
import com.webapp.model.House;

public interface HouseDao extends BaseDao<House> {
	public List<House> findByType(String typeString);
	public List<House> findAll(Parameter parameter);
}
