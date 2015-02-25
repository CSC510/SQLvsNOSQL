package com.thinkgem.jeesite.modules.or.dao;

import org.springframework.stereotype.Repository;

import com.thinkgem.jeesite.common.persistence.BaseSQLDao;
import com.thinkgem.jeesite.modules.or.entity.House;

@Repository
public class HouseSQLDao extends BaseSQLDao<House> implements HouseDao{

}
