package com.webapp.daoimpl.mdb;


import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.webapp.common.util.Reflections;
import com.webapp.dao.BaseDao;

@Component
public class BaseMDBImpl<T> implements BaseDao<T>  {

	@Resource(name = "mongoTemplate")
	protected MongoOperations mongoTemplate;

	protected Class<?> entityClass;
	
	public BaseMDBImpl(){
		entityClass = Reflections.getClassGenricType(getClass());
	}
	
	public Class<?> getEntityClass(){
		return this.entityClass;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public T findById(Serializable id) {
		// TODO Auto-generated method stub
		Query query=new Query();
		query.addCriteria(Criteria.where("studentId").is(id));
		if (this.mongoTemplate.findOne(query, entityClass)!=null) {
			return (T) this.mongoTemplate.findOne(query, entityClass);	
		}
		else return null;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return (List<T>) this.mongoTemplate.findAll(entityClass);
	}

	
	@Override
	public List<T> findAll(String query) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public void deleteById(Serializable id) {
		// TODO Auto-generated method stub

		mongoTemplate.remove(this.findById(id));
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		mongoTemplate.remove(entity);
	}

	@Override
	public void save(T entity) {
		
		// TODO Auto-generated method stub
		mongoTemplate.save(entity);
	}

	@Override
	public void save(List<T> entities) {
		// TODO Auto-generated method stub
		for(T entity:entities){
			mongoTemplate.save(entity);
		}
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		
	}
	
	public BasicQuery createQuery(String qlstr){
		BasicQuery query = new BasicQuery(qlstr);
		
		return query;
	}

}
