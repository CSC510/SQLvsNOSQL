package com.webapp.daoimpl.sql;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.webapp.common.util.Reflections;
import com.webapp.dao.BaseDao;
import com.webapp.model.House;

@Component
public class BaseSQLImpl<T> implements BaseDao<T> {
	
   
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	
	private Class<?> entityClass;
	
	public BaseSQLImpl(){
		this.entityClass =  Reflections.getClassGenricType(getClass());
	}
	
	public Class<?> getEntityClass(){
		return this.entityClass;
	}

	@Override
	public T findById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAll(String qlstr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Serializable id) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("delete from " + entityClass.getSimpleName()+" where id=?",id);
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(List<T> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String qlstr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		
		return this.jdbcTemplate.query("select * from "+entityClass.getSimpleName(), new BeanPropertyRowMapper(this.entityClass));
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		jdbcTemplate.update("delete from " + entityClass.getSimpleName()+" where id>0");
	}

	@Override
	public T findByQuery(String str) {
		// TODO Auto-generated method stub
		return (T) this.jdbcTemplate.queryForObject(str, new BeanPropertyRowMapper(this.entityClass));
	}
}
