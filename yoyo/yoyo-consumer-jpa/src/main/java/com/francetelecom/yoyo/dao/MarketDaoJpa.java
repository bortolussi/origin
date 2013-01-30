package com.francetelecom.yoyo.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.francetelecom.yoyo.model.persistent.Market;
import com.francetelecom.yoyo.technicalservice.exception.NotFoundException;
import com.francetelecom.yoyo.technicalservice.exception.TechnicalException;

/**
 * Market management DAO interface
 * 
 * @author Clara
 */
public interface MarketDaoJpa extends GenericDaoJpa<Market, Integer> {

	/**
	 * Delete Market with provided id (can't be a generic method because the
	 * primary key is not necessary an Integer)
	 * 
	 * @param idMarket
	 *            market id to be removed
	 * @return void
	 * @throws DataAccessException
	 */
	public void remove(Integer idMarket);

	/**
	 * Find market with provided name.
	 * 
	 * @return the list of markets found
	 * @throws NotFoundException
	 * @throws DataAccessException
	 * @throws TechnicalException
	 */
	public List<Market> findByName(String name);
	
	/**
	 * find market with same exact name
	 * 
	 * @param nom
	 *            market name
	 * @return true if market exists, false otherwise
	 */
	public boolean existsMarketWithName(String nom);

}