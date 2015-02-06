package com.webapp.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
    /**
     * Find an Entity By ID
     * @param id
     * @return
     */
	public T get(Serializable id);
	
	/**
	 * Find All the Entity
	 * @param query
	 */
	public List<T> findAll(String query);
	
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
	 * @param entity
	 */
	public void update(T entity);
	
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
}
