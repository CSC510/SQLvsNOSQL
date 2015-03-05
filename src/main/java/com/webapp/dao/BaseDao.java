package com.webapp.dao;

import java.io.Serializable;
import java.util.List;

import com.webapp.daoimpl.mdb.Parameter;

public interface BaseDao<T> {
    /**
     * Find an Entity By ID
     * @param id
     * @return
     */
	public T findById(Serializable id);
	
	/**
	 * Find All The Entity
	 * @return
	 */
	public List<T> findAll();
	/**
	 * Find All the Entity Using Query
	 * @param qlstr
	 */
	public List<T> findAll(String qlstr);
	
	/**
	 * Save Entity
	 * @param entity
	 */
	public void save(T entity);
	
	/**
	 * Save a List of Entities
	 * @param entities
	 */
	public void save(List<T> entities);
	
	/**
	 * Update 
	 * @param qlstr TODO
	 */
	public void update(String qlstr);
	/**
	 * Delete Entity By id
	 * @param id
	 */
	
	public void deleteById(Serializable id);
	
	/**
	 * Delete Entity
	 * @param entity
	 */
	public void delete(T entity);
	
	public void deleteAll();
	
}
