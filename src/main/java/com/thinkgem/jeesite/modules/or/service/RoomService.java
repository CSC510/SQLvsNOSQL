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
import com.thinkgem.jeesite.modules.or.entity.Room;
import com.thinkgem.jeesite.modules.or.dao.RoomDao;
import com.thinkgem.jeesite.modules.or.dao.RoomSQLDao;

/**
 * roomService
 * @author Jentle
 * @version 2015-02-26
 */
@Component
@Transactional(readOnly = true)
public class RoomService extends BaseService {

	@Resource(name = "roomSQLDao")
	private RoomSQLDao roomDao;
	@Autowired
	private HouseService houseService;
	
	public Room get(String id) {
		return roomDao.get(id);
	}
	
	public Page<Room> find(Page<Room> page, Room room) {
		DetachedCriteria dc = roomDao.createDetachedCriteria();
		dc.createAlias("house", "house");
		if(room.getHouse()!=null&& StringUtils.isNotBlank(room.getHouse().getId())){
			House house = houseService.get(room.getHouse().getId());
			if(house!=null){
				dc.add(Restrictions.eq("house.id", house.getId()));
				room.setHouse(house);
			}
		}
		if(room.getRentStatus()!=null){
			dc.add(Restrictions.like("rentStatus", room.getRentStatus()));
		}
		dc.add(Restrictions.eq("delFlag", Room.DEL_FLAG_NORMAL));
		page = roomDao.find(page,dc);
		return page;
	}
	
	@Transactional(readOnly = false)
	public void save(Room room) {
		roomDao.save(room);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		roomDao.deleteById(id);
	}
	
}
