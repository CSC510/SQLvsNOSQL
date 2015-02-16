package com.webapp.daoimpl.mdb;


import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.webapp.common.util.Reflections;
import com.webapp.dao.BaseDao;

@Component
public class BaseMDBImpl<T> implements BaseDao<T> {

	@Resource(name = "mongoTemplate")
	protected MongoOperations mongoTemplate;

	protected Class<?> entityClass;
	
	public BaseMDBImpl(){
		entityClass = Reflections.getClassGenricType(getClass());
	}
	
	public Class<?> getEntityClass() {
		return this.entityClass;
	}
			
	@SuppressWarnings("unchecked")
	@Override
	public T findById(Serializable id) {
		return  (T)this.mongoTemplate.findById(id, entityClass);
	}
        
        @SuppressWarnings("unchecked")
	public T findOne(String qlstr) {
		return  (T) this.mongoTemplate.findOne(new BasicQuery(qlstr), entityClass);
	}
	
	/**
        * Find One Entity with Limitation
        * @param parameter
        * @return
        */
        @SuppressWarnings("unchecked")
	public T findOne( Parameter parameter) {
    	Query query = createQuery( parameter,null);
    	return (T) this.mongoTemplate.findOne(query, entityClass);
        }
        
        
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(String qlstr) {
		// TODO Auto-generated method stub
		BasicQuery query = new BasicQuery(qlstr);
		return (List<T>) this.mongoTemplate.find(query, entityClass);
	}
        
        /**
	 * Find List Of Entities with Limitations
	 * @param parameter, Query parameters
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll(Parameter parameter) {
		Query query = createQuery( parameter,null);
    	        return  (List<T>) this.mongoTemplate.find(query, entityClass); 
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return (List<T>) this.mongoTemplate.findAll(entityClass);
	}
	
	@Override
	public void deleteById(Serializable id) {
//		Query query = new Query();
//		query.addCriteria(Criteria.where("_id").is(id));
		T t=findById(id);
		this.mongoTemplate.remove(t);
	}

	@Override
	public void delete(T entity) {	
		mongoTemplate.remove(entity);
	}
        
        /**
        *  Get Id Field via Reflection
        */
	public Field getIdField() {
		for(Field field : this.entityClass.getDeclaredFields() ) {
			Id idAnn = field.getAnnotation(Id.class);
			if(idAnn != null){
				return field;
			}
		}
		return null;
	}
	
	public Query createIdQuery(Serializable id) {	
		String ID = getIdField().getName();
		Query query = new Query();
		return query.addCriteria(Criteria.where(ID).is(id));
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
	public void update(String qlstr) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Create Query, translate a HashMap parameter to Query.
	 * eg. new Parameter().put("name", "xxx").put("age",24) --> {"name" : "xxx" , "age" : 24 }
	 * @param parameters 
	 * @param qlstr
	 * @return
	 */
	public Query createQuery( Parameter parameters,String qlstr) {
		Query query = new Query();		
		
	    for( String key : parameters.keySet()) {
	    	Object value = parameters.get(key);	    	
	    	if( value instanceof Collection<?>) {
	    		query.addCriteria(Criteria.where(key).in(value));
	    	}else if(value instanceof Object[]) {
	    		query.addCriteria(Criteria.where(key).in(value));
            }else{
            	query.addCriteria(Criteria.where(key).is(value));
            }
	    }
	    return query;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		this.mongoTemplate.dropCollection(entityClass);
	}

}
