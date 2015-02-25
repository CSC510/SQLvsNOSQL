package com.thinkgem.jeesite.common.persistence;

import java.io.Serializable;
import java.util.List;
/**
 * 
 * @author jentle
 *
 * @param <T>
 */
public interface BaseDao <T> {
	/**
     * Find an Entity By ID
     * @param id
     * @return
     */
	public T get(Serializable id);
	
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
	public int update(String qlstr);
	
	/**
	 * Delete Entity By id
	 * @param id
	 */
	public int deleteById(Serializable id);
	

	
}
