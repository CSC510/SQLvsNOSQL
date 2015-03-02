/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.thinkgem.jeesite.modules.or.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.commons.lang3.ObjectUtils;
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
import com.thinkgem.jeesite.modules.or.dao.ApplicationDao;
import com.thinkgem.jeesite.modules.or.dao.ApplicationSQLDao;

/**
 * applicationService
 * @author Jentle
 * @version 2015-02-22
 */
@Component
@Transactional(readOnly = true)
public class ApplicationService extends BaseService {

	@Resource(name="applicationSQLDao")
	private ApplicationSQLDao applicationDao;	
	@Autowired
	private HouseService houseService;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	protected TaskService taskService;
	@Autowired
	protected HistoryService historyService;
	@Autowired
	protected RepositoryService repositoryService;
	@Autowired
	private IdentityService identityService;
	
	private String processDefinitionKey = "application";
	
	public Application get(String id) {
		return applicationDao.get(id);
	}
	
	public Page<Application> find(Page<Application> page, Application application) {
		DetachedCriteria dc = applicationDao.createDetachedCriteria();
		if(application.getHouse()!=null&&StringUtils.isNotBlank(application.getHouse().getId())){
			House house = houseService.get(application.getHouse().getId());
			if(house!=null){
				dc.add(Restrictions.eq("house.id", house.getId()));
				application.setHouse(house);
				if(house.getRentRooms()!=null){
					dc.add(Restrictions.in("room.id", house.getRoomIds()));
				}
			}
		}
		if (StringUtils.isNotBlank(application.getIds())){
			dc.add(Restrictions.in("id", getIdList(application.getIds())));
		}
		if(application.getCreateDateStart()!=null) {
			dc.add(Restrictions.ge("createDate", application.getCreateDateStart()));
		} 
		if(application.getCreateDateEnd()!=null) {
			dc.add(Restrictions.le("createDate", application.getCreateDateEnd()));
		} 

		dc.add(Restrictions.eq("delFlag", Application.DEL_FLAG_NORMAL));
		page= applicationDao.find(page,dc);
	    return page;
	}
	
	@Transactional(readOnly = false)
	public void save(Application application) {
		applicationDao.save(application);
		
		String businessKey = application.getId().toString();
	    // set the applicant user ID，engine will load user id to activiti:initiator
		
		identityService.setAuthenticatedUserId(ObjectUtils.toString(application.getCreateBy().getId()));
		//ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, businessKey);
		//String processInstanceId = processInstance.getId();
		//application.setProcessInstanceId(processInstanceId);
		//application.setProcessStatus(taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult().getName());
		applicationDao.save(application);
		
		
	}
	
	
	@Transactional
	public void audit(Application application){
		
	}
	@Transactional(readOnly = false)
	public void delete(String id) {
		applicationDao.deleteById(id);
	}
	
}
