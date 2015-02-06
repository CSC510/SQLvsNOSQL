package com.webapp.daoimpl.mdb;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.sun.org.apache.regexp.internal.recompile;
import com.webapp.dao.UserDao;
import com.webapp.model.User;


@Component
public class UserMDBImpl extends BaseMDBImpl<User> implements UserDao{


	@Override
	public User findById(Serializable id) {
		// TODO Auto-generated method stub
		Query query=new Query();
		query.addCriteria(Criteria.where("studentId").is(id));
		if (this.mongoTemplate.findOne(query, entityClass)!=null) {
			return this.mongoTemplate.findOne(query, User.class);	
		}
		else return null;
	}
	public void deleteById(Serializable id) {
		Query query=new Query();
		query.addCriteria(Criteria.where("studentId").is(id));
		this.mongoTemplate.remove(query, User.class);
	}
	@Override
	public List<User> findByName(String name) {
		// TODO Auto-generated method stub
		Query query=new Query();
		query.addCriteria(Criteria.where("name").is(name));
		
		if (this.mongoTemplate.find(query, User.class)!=null) {
			return this.mongoTemplate.find(query, User.class);
		}
		else return null;
	}
}
