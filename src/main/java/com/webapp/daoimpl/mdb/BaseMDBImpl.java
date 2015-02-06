package com.webapp.daoimpl.mdb;


import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;


import com.webapp.common.util.Reflections;
import com.webapp.dao.BaseDao;
import com.webapp.model.User;

@Component
public class BaseMDBImpl<T> implements BaseDao<T>  {

	@Resource(name = "mongoTemplate")
	protected MongoOperations mongoTemplate;
	//public Class<?> entityClass=Reflections.getClassGenricType(getClass());
	
	@Override
	public List<T> findAll(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findbyId(Serializable id) {
		// TODO Auto-generated method stub
		Query query=new Query();
		query.addCriteria(Criteria.where("studentId").is(id));
//		return (T)this.mongoTemplate.findOne(query, entityClass );
		return null;
	}

	@Override
	public void deleteById(Serializable id) {
		// TODO Auto-generated method stub
		T t=this.findbyId(id);
		if (t!=null) {
			mongoTemplate.remove(t);	
		}
	
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
	
	
}
