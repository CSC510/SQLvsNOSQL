package com.webapp.dao;

import java.util.List;

import com.webapp.model.House;

public interface HouseDao extends BaseDao<House> {
	public List<House> findByType(String typeString);
}
