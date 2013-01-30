package com.francetelecom.yoyo.application;

import java.util.List;
import java.util.Map;

import com.francetelecom.yoyo.model.MarketBean;
import com.francetelecom.yoyo.technicalservice.exception.InvalidMarketException;
import com.francetelecom.yoyo.technicalservice.exception.NotFoundException;
import com.francetelecom.yoyo.technicalservice.exception.TechnicalException;

/**
 * application interface for market component
 * 
 * @author Clara
 */
public interface ManageMarket {

	/**
	 * Find all markets
	 * 
	 * @return Map of markets
	 * @throws NotFoundException
	 *             if no market found
	 * @throws TechnicalException
	 *             if data access error
	 */
	Map<Integer, MarketBean> findAllMarkets() throws NotFoundException,
			TechnicalException;

	/**
	 * find market which name contains parameter
	 * 
	 * @param name
	 *            String used to search for market names
	 * @return List of market beans
	 * @throws NotFoundException
	 *             if no market found
	 * @throws TechnicalException
	 *             if data access error
	 */
	List<MarketBean> findMarketByName(String name) throws NotFoundException,
			TechnicalException;

	/**
	 * Create market
	 * 
	 * @param MarketBean
	 *            a market
	 * @return the id of the created market
	 * @throws InvalidMarketException
	 *             if market already exists
	 * @throws TechnicalException
	 *             if data access error
	 */
	Integer createMarket(MarketBean market) throws InvalidMarketException,
			TechnicalException;

	/**
	 * Modify market
	 * 
	 * @param MarketBean
	 *            a market
	 * @throws InvalidMarketException
	 *             if market update fails
	 * @throws TechnicalException
	 *             if data access error
	 * @throws NotFoundException 
	 *             if market does not exist
	 */
	void modifyMarket(MarketBean market) throws InvalidMarketException,
			TechnicalException, NotFoundException;

	/**
	 * Delete market
	 * 
	 * @param idMarket
	 *            market id
	 * @throws InvalidMarketException
	 *             if market deletion fails
	 * @throws TechnicalException
	 *             if data access error
	 */
	void deleteMarket(int idMarket) throws InvalidMarketException,
			TechnicalException;

	/**
	 * Consult market
	 * 
	 * @param idMarket
	 *            market id
	 * @throws NotFoundException
	 *             if market does not exist
	 * @throws TechnicalException
	 *             if data access error
	 */
	MarketBean consultMarket(int idMarket) throws InvalidMarketException,
			NotFoundException;
}