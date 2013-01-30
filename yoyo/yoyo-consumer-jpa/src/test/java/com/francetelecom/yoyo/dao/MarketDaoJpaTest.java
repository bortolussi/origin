package com.francetelecom.yoyo.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.francetelecom.yoyo.dao.MarketDaoJpa;
import com.francetelecom.yoyo.model.persistent.Market;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContextTest.xml" })
public class MarketDaoJpaTest {

	@Autowired
	protected MarketDaoJpa marketDaoJpa;

	/**
	 * Test method for market creation
	 * 
	 * @see com.francetelecom.yoyo.dao.GenericDaoJpa#persist(Object)
	 */
	@Test
	@Transactional
	public void testCreateMarket() throws DataAccessException {

		Market market = new Market("mock name", "mock description");
		marketDaoJpa.persist(market);
		marketDaoJpa.flush();
	}

	/**
	 * Test method for duplicate market creation
	 * 
	 * @see com.francetelecom.yoyo.dao.GenericDaoJpa#persist(Object)
	 */
	@Test(expected = DataAccessException.class)
	@Transactional
	public void testCreateMarketDuplicate() throws DataAccessException {

		Market market1 = new Market("mock name", "mock description");
		Market market2 = new Market("mock name", "mock description");
		marketDaoJpa.persist(market1);
		marketDaoJpa.persist(market2);
		marketDaoJpa.flush();
	}

	/**
	 * Test method for market modification
	 * 
	 * @see com.francetelecom.yoyo.dao.GenericDaoJpa#persist(Object)
	 */
	@Test
	@Transactional
	public void testModifyMarket() throws DataAccessException {

		Market market = new Market("mock name", "mock description");
		marketDaoJpa.persist(market);
		market.setDescription("new description");
		marketDaoJpa.flush();
	}

	/**
	 * Test method for market remove
	 * 
	 * @see com.francetelecom.yoyo.dao.GenericDaoJpa#persist(Object)
	 */
	@Test
	@Transactional
	public void testDeleteMarket() throws DataAccessException {

		Market market = new Market("mock name", "mock description");
		marketDaoJpa.persist(market);
		marketDaoJpa.remove(market);
		marketDaoJpa.flush();
	}

	/**
	 * Test method for market remove by Id
	 * 
	 * @see com.francetelecom.yoyo.dao.GenericDaoJpa#persist(Object)
	 */
	@Test
	@Transactional
	public void testDeleteMarketById() throws DataAccessException {

		Market market = new Market("mock name", "mock description");
		marketDaoJpa.persist(market);
		int id = market.getId();
		marketDaoJpa.remove(id);
		marketDaoJpa.flush();
	}

	/**
	 * Test method for market modification
	 * 
	 * @see com.francetelecom.yoyo.dao.GenericDaoJpa#persist(Object)
	 */
	@Test(expected = InvalidDataAccessApiUsageException.class)
	@Transactional
	public void testDeleteNotExistingMarket() throws DataAccessException {

		marketDaoJpa.remove(999);
		marketDaoJpa.flush();
	}

	/**
	 * Test method for market retrieve
	 * 
	 * @see com.francetelecom.yoyo.dao.GenericDaoJpa#persist(Object)
	 */
	@Test
	@Transactional
	public void testFindAllMarket() throws DataAccessException {

		Market market1 = new Market("mock name 1", "mock description");
		marketDaoJpa.persist(market1);
		Market market2 = new Market("mock name 2", "mock description");
		marketDaoJpa.persist(market2);
		List<Market> list = marketDaoJpa.findAll();
		assertEquals(list.size(), 2);
		marketDaoJpa.flush();
	}

	/**
	 * Test method for market search
	 * 
	 * @see com.francetelecom.yoyo.dao.GenericDaoJpa#persist(Object)
	 */
	@Test
	@Transactional
	public void testFindMarketByName() throws DataAccessException {

		Market market1 = new Market("mock name 1", "mock description");
		marketDaoJpa.persist(market1);
		Market market2 = new Market("mock name 2", "mock description");
		marketDaoJpa.persist(market2);
		List<Market> list = marketDaoJpa.findByName("name");
		assertEquals(list.size(), 2);
		list = marketDaoJpa.findByName("2");
		assertEquals(list.size(), 1);
		list = marketDaoJpa.findByName("3");
		assertEquals(list.size(), 0);
		marketDaoJpa.flush();
	}

}
