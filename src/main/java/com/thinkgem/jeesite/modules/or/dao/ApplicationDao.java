/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.thinkgem.jeesite.modules.or.dao;

import org.springframework.stereotype.Repository;

import com.thinkgem.jeesite.common.persistence.BaseDao;
import com.thinkgem.jeesite.common.persistence.Parameter;
import com.thinkgem.jeesite.modules.or.entity.Application;

/**
 * applicationDAO interface
 * @author Jentle
 * @version 2015-02-22
 */
@Repository
public interface ApplicationDao extends BaseDao<Application> {
	
}
