package com.francetelecom.yoyo.business.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.ObjectRetrievalFailureException;

import com.francetelecom.yoyo.business.ManageMarketBusiness;
import com.francetelecom.yoyo.business.transform.MarketTransform;
import com.francetelecom.yoyo.dao.MarketDaoJpa;
import com.francetelecom.yoyo.model.MarketBean;
import com.francetelecom.yoyo.model.persistent.Market;
import com.francetelecom.yoyo.technicalservice.exception.InvalidMarketException;
import com.francetelecom.yoyo.technicalservice.exception.NotFoundException;
import com.francetelecom.yoyo.technicalservice.exception.OptimisticLockingFailureException;
import com.francetelecom.yoyo.technicalservice.exception.TechnicalException;

/**
 * Business implementation for Market component
 * 
 * @author Clara
 */
public class ManageMarketBusinessImpl implements ManageMarketBusiness {

	private static final Logger log = LoggerFactory.getLogger(ManageMarketBusinessImpl.class);

	private MarketDaoJpa marketDao = null;

	/**
	 * MarketDao setter filled by dependency injection
	 * 
	 * @param marketDao
	 *            the marketDao to inject
	 */
	public void setMarketDao(MarketDaoJpa marketDao) {
		this.marketDao = marketDao;
	}

	public static void checkMarketID(Integer id) throws InvalidMarketException {
		String message = "A submited market has an empty ID";
		if (id == null) {
			log.warn(message);
			throw new InvalidMarketException(message);
		}
	}

	public static void checkMarketVersion(Integer version) throws InvalidMarketException {
		String message = "A submited market has an empty version";
		if (version == null) {
			log.warn(message);
			throw new InvalidMarketException(message);
		}
	}

	public static void checkMarketName(String name) throws InvalidMarketException {
		String message;
		if (name == null || name.isEmpty()) {
			message = "A submited market has an empty name";
			log.warn(message);
			throw new InvalidMarketException(message);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<Integer, MarketBean> findAllMarkets() throws NotFoundException, TechnicalException {
		Collection<Market> marketPersistCollection = null;
		Map<Integer, MarketBean> marketBeanMap = null;

		try {
			marketPersistCollection = marketDao.findAll();

			if (marketPersistCollection == null || marketPersistCollection.isEmpty()) {
				String message = "no market found";
				log.warn(message);
				throw new NotFoundException(message);
			}

			marketBeanMap = MarketTransform.persistant2BeanMap(marketPersistCollection);
		} catch (DataAccessException e) {
			String message = "Error getting all markets";
			log.error(message, e);
			throw new TechnicalException(message, e);
		}

		return marketBeanMap;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer createMarket(MarketBean marketBean) throws InvalidMarketException, TechnicalException {

		checkMarketName(marketBean.getName());

		Market marketPersist = MarketTransform.bean2Persistant(marketBean);

		try {
			// Checking there is no other market with the same name
			if (marketDao.existsMarketWithName(marketBean.getName())) {
				log.warn("A market with the same name (" + marketBean.getName() + ") already exists");
				throw new InvalidMarketException("A market with the same name (" + marketBean.getName() + ") already exists");
			}

			// No problem ... we can persist the new market
			marketDao.persist(marketPersist);

			return marketPersist.getId();

		} catch (DataAccessException e) {
			// Other technical errors
			String message = "Error creating market " + marketBean.getName();
			log.error(message, e);
			throw new TechnicalException(message, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void modifyMarket(MarketBean marketBean) throws InvalidMarketException, TechnicalException, NotFoundException {

		checkMarketID(marketBean.getId());
		checkMarketVersion(marketBean.getVersion());
		checkMarketName(marketBean.getName());

		Market marketPersist;
		try {
			marketPersist = marketDao.find(marketBean.getId());
			if (marketPersist == null) {
				String message = "Market #" + marketBean.getId() + " not available";
				log.error(message);
				throw new NotFoundException(message);
			}
		} catch (ObjectRetrievalFailureException e) {
			String message = "Error modifying market " + marketBean.getName();
			log.error(message, e);
			throw new InvalidMarketException(message, e);
		} catch (DataAccessException e) {
			String message = "Data access error " + marketBean.getId();
			log.error(message, e);
			throw new TechnicalException(message, e);
		}

		// check the versions
		if (marketPersist.getVersion() != marketBean.getVersion())
			throw new OptimisticLockingFailureException("market version has changed");

		// if market name has changed ...
		if (!marketPersist.getName().equals(marketBean.getName())) {
			// Checking there is no other market with the same new name
			if (marketDao.existsMarketWithName(marketBean.getName())) {
				log.warn("A market with the same name (" + marketBean.getName() + ") already exists");
				throw new InvalidMarketException("A market with the same name (" + marketBean.getName() + ") already exists");
			}
		}
		marketPersist.setName(marketBean.getName());
		marketPersist.setDescription(marketBean.getDescription());

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteMarket(Integer idMarket) throws InvalidMarketException, TechnicalException {
		try {
			marketDao.remove(idMarket);
			// Flush to get potential exception
			marketDao.flush();
		} catch (ObjectRetrievalFailureException e) {
			String message = "Error deleting market " + idMarket;
			log.error(message, e);
			throw new InvalidMarketException(message, e);
		} catch (DataIntegrityViolationException e) {
			// should not occur here but could in more complex application
			String message = "cannot delete market " + idMarket;
			log.error(message, e);
			throw new InvalidMarketException(message, e);
		} catch (DataAccessException e) {
			String message = "Error deleting market " + idMarket;
			log.error(message, e);
			throw new TechnicalException(message, e);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MarketBean getMarket(Integer idMarket) throws NotFoundException, TechnicalException {
		try {
			Market marketPersistant = marketDao.find(idMarket);
			if (marketPersistant == null) {
				String message = "Market #" + idMarket + " not available";
				log.error(message);
				throw new NotFoundException(message);
			}
			return MarketTransform.persistant2Bean(marketPersistant);
		} catch (ObjectRetrievalFailureException e) {
			String message = "Invalid market";
			log.error(message, e);
			throw new TechnicalException(message, e);
		} catch (DataAccessException e) {
			String message = "Data not available";
			log.error(message, e);
			throw new TechnicalException(message, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<MarketBean> getMarketByName(String name) throws NotFoundException, TechnicalException {
		List<Market> marketsPersistants = null;
		try {
			marketsPersistants = marketDao.findByName(name);
		} catch (DataAccessException e) {
			String message = "Probl�me d'acc�s aux donn�es";
			log.error(message, e);
			throw new TechnicalException(message, e);
		}

		// scan result
		if (marketsPersistants == null || marketsPersistants.size() == 0) {
			String message = "no market found";
			log.info(message);
			throw new NotFoundException(message);
		}

		// transform to DTO
		List<MarketBean> listMarkets = MarketTransform.persistant2BeanCollection(marketsPersistants);

		return listMarkets;
	}

}
