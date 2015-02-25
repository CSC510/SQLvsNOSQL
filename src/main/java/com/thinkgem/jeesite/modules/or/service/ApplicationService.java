/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.thinkgem.jeesite.modules.or.service;

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
import com.thinkgem.jeesite.modules.or.dao.ApplicationDao;

/**
 * applicationService
 * @author Jentle
 * @version 2015-02-22
 */
@Component
@Transactional(readOnly = true)
public class ApplicationService extends BaseService {

	@Resource(name="applicationSQLDao")
	private ApplicationDao applicationDao;	
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

		return null;
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
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		applicationDao.deleteById(id);
	}
	
}
