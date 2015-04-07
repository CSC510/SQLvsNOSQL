package com.webapp.daoimpl.sql;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.webapp.common.util.Reflections;
import com.webapp.dao.BaseDao;
import com.webapp.common.persistence.Parameter;
import com.webapp.model.House;
import com.webapp.model.User;

@Component
public class BaseSQLImpl<T> implements BaseDao<T> {
	
   
	@Autowired
	protected SessionFactory sessionFactory;
	
	
	private Class<?> entityClass;
	
	public BaseSQLImpl(){
		this.entityClass =  Reflections.getClassGenricType(getClass());
	}
	
	
	public Class<?> getEntityClass(){
		return this.entityClass;
	}

	/**
	 * Get Session
	 */
	public Session getSession(){  
	  return sessionFactory.getCurrentSession();
	}

	/**
	 * Force to flush into database
	 */
	public void flush(){
		getSession().flush();
	}

	
	/**
	 * Clear Cache
	 */
	public void clear(){ 
		getSession().clear();
	}
	
	//----------------

    /**
	 * QL query
	 * @param qlString
	 * @return
	 */
	public <E> List<E> find(String qlString){
		return find(qlString, null);
	}
    
    /**
	 * QL query
	 * @param qlString
	 * @param parameter
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <E> List<E> find(String qlString, Parameter parameter){
		Query query = createQuery(qlString, parameter);
		return query.list();
	}
	
	/**
	 * QL Query All
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll(){
		return getSession().createCriteria(entityClass).list();
	}
	
	/**
	 * Get Entity By id
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T get(Serializable id){
		return (T)getSession().get(entityClass, id);
	}
	
	/**
	 * Get Entity by ql
	 * @param qlString
	 * @return
	 */
	public T getByHql(String qlString){
		return getByHql(qlString, null);
	}
	
	/**
	 * Get Entity by ql and parameter
	 * @param qlString
	 * @param parameter
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T getByHql(String qlString, Parameter parameter){
		Query query = createQuery(qlString, parameter);
		return (T)query.uniqueResult();
	}
	
	/**
	 * save or update existed entity
	 * @param entity
	 */
	public void save(T entity){
		try {
			// Get id
			Object id = null;
			for (Method method : entity.getClass().getMethods()){
				Id idAnn = method.getAnnotation(Id.class);
				if (idAnn != null){
					id = method.invoke(entity);
					break;
				}
			}
			// Prepersist
			if (StringUtils.isBlank((String)id)){
				for (Method method : entity.getClass().getMethods()){
					PrePersist pp = method.getAnnotation(PrePersist.class);
					if (pp != null){
						method.invoke(entity);
						break;
					}
				}
			}
			// Preupdate
			else{
				for (Method method : entity.getClass().getMethods()){
					PreUpdate pu = method.getAnnotation(PreUpdate.class);
					if (pu != null){
						method.invoke(entity);
						break;
					}
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		//getSession().saveOrUpdate(entity);
		getSession().save(entity);
	}
	
	/**
	 * save entity list
	 * @param entityList
	 */
	public void save(List<T> entityList){
		for (T entity : entityList){
			save(entity);
		}
	}

	/**
	 * update
	 * @param qlString
	 * @return
	 */
	public int update(String qlString){
		return update(qlString, null);
	}
	
	/**
	 * 更新
	 * @param qlString
	 * @param parameter
	 * @return
	 */
	public int update(String qlString, Parameter parameter){
		return createQuery(qlString, parameter).executeUpdate();
	}
	
	
	@Override
	public T findById(Serializable id) {
		return get(id);
	}

	@Override
	public List<T> findAll(String qlstr) {
		return null;
	}

	/**
	 * Create QL query
	 * @param qlString
	 * @param parameter
	 * @return
	 */
	public Query createQuery(String qlString, Parameter parameter){
		Query query = getSession().createQuery(qlString);
		setParameter(query, parameter);
		return query;
	}
	
	//-----------SQL query------------------------
	/**
	 * SQL query
	 * @param sqlString
	 * @return
	 */
	public <E> List<E> findBySql(String sqlString){
		return findBySql(sqlString, null, null);
	}
	
	/**
	 * SQL query
	 * @param sqlString
	 * @param parameter
	 * @return
	 */
	public <E> List<E> findBySql(String sqlString, Parameter parameter){
		return findBySql(sqlString, parameter, null);
	}
	
	/**
	 * SQL query
	 * @param sqlString
	 * @param resultClass
	 * @param parameter
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <E> List<E> findBySql(String sqlString, Parameter parameter, Class<?> resultClass){
		SQLQuery query = createSqlQuery(sqlString, parameter);
		setResultTransformer(query, resultClass);
		return query.list();
	}
	
	/**
	 * SQL update
	 * @param sqlString
	 * @param parameter
	 * @return
	 */
	public int updateBySql(String sqlString, Parameter parameter){
		return createSqlQuery(sqlString, parameter).executeUpdate();
	}
	
	private String parameter2String(String sqlstr, Parameter parameter){
		
		if(parameter==null||parameter.size()==0){
			return sqlstr;
		}
		
		String query = sqlstr;
		if (!sqlstr.toLowerCase().contains("where")){
			query +=" where ";
		}else{
			query +=" and ";
		}
		
		
		for (String key: parameter.keySet()){
			Object value = parameter.get(key);
			if( value instanceof Collection<?>){
				;
			}else if(value instanceof Object[]){
				query += key  ;
				for(Object ob : (Object[])value){
					query += " "+ob;
				}
			}else {
				query  += key+"=";
				/*If  value is string, should be quote*/
				if( value instanceof String){        
					query +="'"+value+"'";
				}else{
					query += value;
				}
			}
			query +=" and ";
		}
		//remove last "and";
		return query.trim().substring(0, query.length()-4);
	}
	
	/**
	 * Create SQL Query
	 * @param sqlString
	 * @param parameter
	 * @return
	 */
	public SQLQuery createSqlQuery(String sqlString, Parameter parameter){
		SQLQuery query = getSession().createSQLQuery(parameter2String(sqlString,parameter));
		//setParameter(query, parameter);
		return query;
	}
	
	
	//------------Tools --------------------------
	/**
	 * Set query result class type
	 * @param query
	 * @param resultClass
	 */
	private void setResultTransformer(SQLQuery query, Class<?> resultClass){
		if (resultClass != null){
			if (resultClass == Map.class){
				query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			}else if (resultClass == List.class){
				query.setResultTransformer(Transformers.TO_LIST);
			}else{
				query.addEntity(resultClass);
			}
		}else{
			query.addEntity(entityClass);
		}
	}
	
	/**
	 * Set query parameters
	 * @param query
	 * @param parameter
	 */
	private void setParameter(Query query, Parameter parameter){
		if (parameter != null) {
            Set<String> keySet = parameter.keySet();
            for (String string : keySet) {
                Object value = parameter.get(string);
                //different parameter type
                if(value instanceof Collection<?>){
                    query.setParameterList(string, (Collection<?>)value);
                }else if(value instanceof Object[]){
                    query.setParameterList(string, (Object[])value);
                }else{
                    query.setParameter(string, value);
                }
            }
        }
	}


	@Override
	public T findByQuery(String str) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteById(Serializable id) {
		getSession().delete(get(id));
	}


	@Override
	public void delete(T entity) {
		getSession().delete(entity);
	}


	@Override
	public void deleteAll() {
		
		
	}


	@Override
	public List<T> findAll(String str,Parameter parameter) {
		return findBySql(str,parameter);
	
	}
}
