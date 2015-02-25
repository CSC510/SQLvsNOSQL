package com.thinkgem.jeesite.modules.or.dao;

import org.springframework.stereotype.Component;

import com.thinkgem.jeesite.common.persistence.BaseSQLDao;
import com.thinkgem.jeesite.modules.or.entity.Application;

@Component
public class ApplicationSQLDao extends BaseSQLDao<Application> implements ApplicationDao {

}
