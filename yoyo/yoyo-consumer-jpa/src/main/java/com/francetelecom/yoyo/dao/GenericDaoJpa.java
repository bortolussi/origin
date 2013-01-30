package com.francetelecom.yoyo.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

/**
 * Generic interface for a JPA persistence service
 * <p>
 * All exceptions are RuntimeException (@see
 * org.springframework.dao.DataAccessException)
 * 
 * @author France Telecom - Clara
 * 
 * @param <T,PK>
 *            Table and primary key
 */
public interface GenericDaoJpa<T, PK> {

	/**
	 * Synchronise entityManager objects in database
	 * 
	 * @throws DataAccessException
	 */
	public void flush();

	/**
	 * Refresh persistent object
	 * 
	 * @param o
	 * @throws DataAccessException
	 */
	public void refresh(T o);

	/**
	 * persist an object in database
	 * 
	 * @param o
	 *            the persistent object to be persisted
	 * @throws DataAccessException
	 */
	public void persist(T o);

	/**
	 * Remove an object from database
	 * 
	 * @param o
	 *            the persistent object to be removed
	 * @throws DataAccessException
	 */
	public void remove(T o);

	/**
	 * load a persistent object with specified id, return null if it does not
	 * exist
	 * 
	 * @param id
	 *            the persistent object id
	 * @return T the persistent object found in database
	 * @throws DataAccessException
	 */
	public T find(PK id);

	/**
	 * load a persistent object with specified id, throw an exception if it does
	 * not exist
	 * 
	 * @param id
	 *            the persistent object id
	 * @return T the persistent object found in database
	 * @throws DataAccessException
	 */
	public T getReference(PK id);

	/**
	 * load all persistent objects specified by DAO component
	 * 
	 * @return List list of persistent objects
	 * @throws DataAccessException
	 */
	public List<T> findAll();

}
