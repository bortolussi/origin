package com.francetelecom.yoyo.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.francetelecom.yoyo.dao.GenericDaoJpa;

/**
 * Generic DAO JPA implementation. An EntityManager is injected by Spring
 * container. A transaction should be started by container before calling these
 * DAO services.
 * 
 * @author Clara
 * @param <T,PK> Table and primary key
 */
@Repository
public abstract class GenericDaoJpaImpl<T, PK> implements GenericDaoJpa<T, PK> {

	protected Class<T> type = null;

	@PersistenceContext
	protected EntityManager em;

	/**
	 * Empty constructor. The real type T is found with generic reflection
	 */
	protected GenericDaoJpaImpl() {
		this.type = this.getParameterizedType(this.getClass());
	}

	/**
	 * Generic reflection. Find and set generic type used
	 */
	@SuppressWarnings("unchecked")
	private Class<T> getParameterizedType(Class<?> clazz) {
		Class<T> specificType = null;
		ParameterizedType parameterizedType = (ParameterizedType) clazz
				.getGenericSuperclass();
		specificType = (Class<T>) parameterizedType.getActualTypeArguments()[0];
		return specificType;
	}

	public void flush() {
		em.flush();
	}

	public void persist(T o) {
		em.persist(o);
	}

	public void remove(T o) {
		em.remove(o);
	}

	public void refresh(T o) {
		em.refresh(o);
	}

	public T find(PK primaryKey) {
		return em.find(type, primaryKey);
	}

	public T getReference(PK primaryKey) {
		return em.getReference(type, primaryKey);
	}

	
	public List<T> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> query = cb.createQuery(type);
		Root<T> root = query.from(type);
		query.select(root);
		TypedQuery<T> tq = em.createQuery(query);
		
		return tq.getResultList();
	}

}
