package com.thinkgem.jeesite.modules.or.dao;

import org.springframework.stereotype.Repository;

import com.thinkgem.jeesite.common.persistence.BaseMdbDao;
import com.thinkgem.jeesite.modules.or.entity.House;

@Repository
public class HouseMdbDao extends BaseMdbDao<House> implements HouseDao{
}
