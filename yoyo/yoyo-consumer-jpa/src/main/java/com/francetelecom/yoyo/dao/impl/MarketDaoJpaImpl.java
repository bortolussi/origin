package com.francetelecom.yoyo.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.francetelecom.yoyo.dao.MarketDaoJpa;
import com.francetelecom.yoyo.model.persistent.Market;

/**
 * Market DAO implementation
 * 
 * @author Clara
 */
@Repository
public class MarketDaoJpaImpl extends GenericDaoJpaImpl<Market, Integer>
		implements MarketDaoJpa {
	
	private final static String COUNT_WITH_EXACT_NAME = 
		"SELECT COUNT(x) FROM Market x where x.name = :name";
	private final static String QUERY_BY_APPROX_NAME = 
		"SELECT x FROM Market x WHERE x.name LIKE :name ORDER BY x.name ASC";
	private final static String QUERY_ALL = 
		"SELECT x FROM Market x ORDER BY x.name ASC";

    /**
     * {@inheritDoc}
     */	
	@Override
	public void remove(Integer idMarket) {
		Market market = null;
		market = em.find(type, idMarket);
		em.remove(market);
	}

    /**
     * {@inheritDoc}
     */	
	@Override
	public List<Market> findByName(String marketName) {
		
		TypedQuery<Market> tq = null;
		
		if (marketName != null && !marketName.equals("")) {
			
			tq = em.createQuery(QUERY_BY_APPROX_NAME,Market.class);
			tq.setParameter("name", "%"+marketName+"%");
			
		} else {
			
			tq = em.createQuery(QUERY_ALL,Market.class);
			
		}

		return tq.getResultList();

	}
	
	public boolean existsMarketWithName(String nom) {
		
		TypedQuery<Number> query = 
			em.createQuery(COUNT_WITH_EXACT_NAME,Number.class);
		
		query.setParameter("name", nom);
		Number result = query.getSingleResult();
		return ((result.intValue() == 0) ? false : true);
		
	}

	
}