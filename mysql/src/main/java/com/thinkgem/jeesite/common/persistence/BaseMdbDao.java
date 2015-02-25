package com.thinkgem.jeesite.common.persistence;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.thinkgem.jeesite.common.utils.Reflections;


@Component
public class BaseMdbDao<T> implements BaseDao<T> {
	@Autowired
	private MongoTemplate mongoTemplate;
	
    protected Class<?> entityClass;
	

	public BaseMdbDao(){
		entityClass = Reflections.getClassGenricType(getClass());
	}
	
	public Class<?> getEntityClass(){
		return this.entityClass;
	}
			
	@SuppressWarnings("unchecked")
	public T findById(Serializable id) {
		return  (T)this.mongoTemplate.findById(id, entityClass);
	}

    @SuppressWarnings("unchecked")
	public T findOne(String qlstr){
		return  (T) this.mongoTemplate.findOne(new BasicQuery(qlstr), entityClass);
		
	}
	
    /**
     * Find One Entity with Limitation
     * @param parameter
     * @return
     */
    @SuppressWarnings("unchecked")
	public T findOne( Parameter parameter){
    	Query query = createQuery( parameter,null);
    	return (T) this.mongoTemplate.findOne(query, entityClass);
    }
    
	@SuppressWarnings("unchecked")
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
	public List<T> findAll(Parameter parameter){
		Query query = createQuery( parameter,null);
    	return  (List<T>) this.mongoTemplate.find(query, entityClass); 
	}
	

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return (List<T>) this.mongoTemplate.findAll(entityClass);
	}
	
	public int deleteById(Serializable id) {
		//Query query = new Query();
		//query.addCriteria(Criteria.where("_id").is(id));
		//this.mongoTemplate.remove(query,entityClass);
		return 0;
	}

	public void delete(T entity) {	
		mongoTemplate.remove(entity);
	}

	
	public Field getIdField(){
		for(Field field : this.entityClass.getDeclaredFields() ){
			Id idAnn = field.getAnnotation(Id.class);
			if(idAnn != null){
				return field;
			}
		}
		return null;
	}
	
	public Query createIdQuery(Serializable id){	
		String ID = getIdField().getName();
		Query query = new Query();
		return query.addCriteria(Criteria.where(ID).is(id));
	}
	
	public void save(T entity) {
		mongoTemplate.save(entity);
	}

	public void save(List<T> entities) {
		for(T entity:entities){
			mongoTemplate.save(entity);
		}
	}

	public int update(String qlstr) {
		return 0;
	
	}
	
	/**
	 * Create Query, translate a HashMap parameter to Query.
	 * eg. new Parameter().put("name", "xxx").put("age",24) --> {"name" : "xxx" , "age" : 24 }
	 * @param parameters 
	 * @param qlstr
	 * @return
	 */
	public Query createQuery( Parameter parameters,String qlstr){
		Query query = new Query();		
		
	    for( String key : parameters.keySet()){
	    	Object value = parameters.get(key);	    	
	    	if( value instanceof Collection<?>){
	    		query.addCriteria(Criteria.where(key).in(value));
	    	}else if(value instanceof Object[]){
	    		query.addCriteria(Criteria.where(key).in(value));
            }else{
            	query.addCriteria(Criteria.where(key).is(value));
            }
	    }

	    return query;
	}

	@Override
	public T get(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

}
