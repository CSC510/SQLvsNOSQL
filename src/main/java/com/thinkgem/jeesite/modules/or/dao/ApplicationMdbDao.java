package com.thinkgem.jeesite.modules.or.dao;

import org.springframework.stereotype.Component;

import com.thinkgem.jeesite.common.persistence.BaseMdbDao;
import com.thinkgem.jeesite.modules.or.entity.Application;

@Component
public class ApplicationMdbDao extends BaseMdbDao<Application> implements ApplicationDao {

}
