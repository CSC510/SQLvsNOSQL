/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.thinkgem.jeesite.modules.or.service;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.BaseService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.or.entity.Application;
import com.thinkgem.jeesite.modules.or.entity.House;
import com.thinkgem.jeesite.modules.or.dao.HouseDao;
import com.thinkgem.jeesite.modules.or.dao.HouseSQLDao;

/**
 * houseService
 * @author ThinkGem
 * @version 2015-02-19
 */
@Component
@Transactional(readOnly = true)
public class HouseService extends BaseService {

	@Resource(name="houseSQLDao")
	private HouseSQLDao houseDao;
	
	public House get(String id) {
		return houseDao.get(id);
	}
	
	public Page<House> find(Page<House> page, House house) {
        DetachedCriteria dc = houseDao.createDetachedCriteria() ;
        if (StringUtils.isNotBlank(house.getIds())){
			dc.add(Restrictions.in("id", getIdList( house.getIds())));
		}
		if( house.getHouseType() != 0) {
			dc.add(Restrictions.like("houseType", house.getHouseType()));
		} 
		if(house.getRentStatus()!= null){
			dc.add(Restrictions.like("rentStatus", house.getRentStatus()));
		} 
		
		dc.add(Restrictions.eq("delFlag", House.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("houseType"));
		page = houseDao.find(page,dc);
		return page;
	}
	
	@Transactional(readOnly = false)
	public void save(House house) {
		houseDao.save(house);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		houseDao.deleteById(id);
	}
	
}
