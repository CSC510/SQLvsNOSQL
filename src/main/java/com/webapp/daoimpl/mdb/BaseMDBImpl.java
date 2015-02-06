package com.webapp.daoimpl.mdb;


import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
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
	    return  (T)this.mongoTemplate.findById(id, entityClass);
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
		mongoTemplate.insert(entity);
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
