/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.thinkgem.jeesite.modules.or.dao;

import org.springframework.stereotype.Repository;

import com.thinkgem.jeesite.common.persistence.BaseDao;
import com.thinkgem.jeesite.modules.or.entity.House;

/**
 * houseDAO interface
 * @author ThinkGem
 * @version 2015-02-19
 */
@Repository
public interface HouseDao extends BaseDao<House> {
	
}
