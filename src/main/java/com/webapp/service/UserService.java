package com.webapp.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.dao.UserDao;
import com.webapp.common.persistence.Parameter;
import com.webapp.model.User;

@Service
@Transactional
public class UserService {
	@Resource(name = "userMDBImpl")
	private UserDao userDao;
	
	public User get(Serializable id){
		return userDao.findById(id);
	}
	
	public List<User> find( User user){
		String sqlstr="select * from user";
		Parameter parameter = new Parameter();
		if(StringUtils.isNotBlank(user.getName())){
			parameter.put("name", user.getName());
		}
		
	
		return userDao.findAll(sqlstr, parameter);
		
	}
	

	public void save(User u){
		userDao.save(u);
	}

	public void delete(User u) {
		userDao.delete(u);
	}
}
