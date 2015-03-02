package com.thinkgem.jeesite.module.or;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.thinkgem.jeesite.common.test.SpringTransactionalContextTests;
import com.thinkgem.jeesite.modules.cms.dao.ArticleDao;
import com.thinkgem.jeesite.modules.cms.dao.CategoryDao;
import com.thinkgem.jeesite.modules.cms.entity.Article;
import com.thinkgem.jeesite.modules.cms.entity.Category;
import com.thinkgem.jeesite.modules.oa.dao.LeaveDao;
import com.thinkgem.jeesite.modules.oa.entity.Leave;
import com.thinkgem.jeesite.modules.or.dao.ApplicationMdbDao;
import com.thinkgem.jeesite.modules.or.dao.ApplicationSQLDao;
import com.thinkgem.jeesite.modules.or.dao.RoomSQLDao;
import com.thinkgem.jeesite.modules.or.entity.Application;
import com.thinkgem.jeesite.modules.or.entity.House;
import com.thinkgem.jeesite.modules.or.entity.Room;
import com.thinkgem.jeesite.modules.or.service.ApplicationService;
import com.thinkgem.jeesite.modules.or.service.HouseService;

public class ApplicationTest extends SpringTransactionalContextTests {
	

	
	@Autowired
	private ApplicationMdbDao applicationMdbDao;
	@Autowired
	private ApplicationSQLDao applicationSQLDao;
	@Autowired
	private RoomSQLDao roomSQLDao;
	@Autowired
	private LeaveDao leaveDao;
	@Autowired
	private HouseService houseService;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ArticleDao articleDao;
	@Test
	public void newApplication(){
		Room room = new Room();
		roomSQLDao.save(room);
	
	}

}
