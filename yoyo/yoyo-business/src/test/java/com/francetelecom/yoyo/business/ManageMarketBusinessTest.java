package com.francetelecom.yoyo.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.francetelecom.yoyo.business.impl.ManageMarketBusinessImpl;
import com.francetelecom.yoyo.dao.MarketDaoJpa;
import com.francetelecom.yoyo.model.MarketBean;
import com.francetelecom.yoyo.model.persistent.Market;
import com.francetelecom.yoyo.technicalservice.exception.InvalidMarketException;
import com.francetelecom.yoyo.technicalservice.exception.NotFoundException;
import com.francetelecom.yoyo.technicalservice.exception.TechnicalException;

public class ManageMarketBusinessTest {

	private ManageMarketBusinessImpl manageMarketBusiness;

	private MarketDaoJpa manageMarketDaoJpaMock;

	/**
	 * setup unit test
	 */
	@Before
	public void setup() {
		// Business layer class to be tested
		manageMarketBusiness = new ManageMarketBusinessImpl();

		// DAO layer class mock
		manageMarketDaoJpaMock = mock(MarketDaoJpa.class,
				"manageMarketDaoJpa Mock");

		// dependency injection
		manageMarketBusiness.setMarketDao(manageMarketDaoJpaMock);
	}

	/**
	 * Test method for searching markets
	 * 
	 * @see com.francetelecom.yoyo.business.ManageMarket#findAllMarkets
	 */
	@Test
	public void testFindAllMarkets() throws NotFoundException,
			TechnicalException {
		// setup
		MarketBean marketBean1 = new MarketBean(1, "name1", "description1");
		MarketBean marketBean2 = new MarketBean(2, "name2", "description2");

		Market market1 = new Market(marketBean1.getName(), marketBean1
				.getDescription());
		market1.setId(marketBean1.getId());
		Market market2 = new Market(marketBean2.getName(), marketBean2
				.getDescription());
		market2.setId(marketBean2.getId());
		List<Market> listMock = new ArrayList<Market>();
		listMock.add(market1);
		listMock.add(market2);

		when(manageMarketDaoJpaMock.findAll()).thenReturn(listMock);

		// execution
		Map<Integer, MarketBean> resultList = manageMarketBusiness
				.findAllMarkets();

		// verification
		assertNotNull(resultList);
		assertEquals("size", 2, resultList.size());
		assertEquals("id", marketBean1.getId(), resultList.get(1).getId());
		assertEquals("name", marketBean1.getName(), resultList.get(1).getName());
		assertEquals("description", marketBean1.getDescription(), resultList
				.get(1).getDescription());
	}

	/**
	 * Test method for empty market List
	 * 
	 * @see com.francetelecom.yoyo.business.ManageMarket#findAllMarkets()
	 */
	@Test(expected = NotFoundException.class)
	public void testFindAllMarketsEmpty() throws NotFoundException,
			TechnicalException {
		// setup
		when(manageMarketDaoJpaMock.findAll()).thenReturn(null);

		// execution
		manageMarketBusiness.findAllMarkets();
	}

	/**
	 * Test method for market creation
	 * 
	 * @see com.francetelecom.yoyo.business.ManageMarket#createMarket(MarketBean)
	 */
	@Test
	public void testCreateMarket() throws InvalidMarketException,
			TechnicalException {

		MarketBean marketBean = new MarketBean("mock name",
				"mock description");
		manageMarketBusiness.createMarket(marketBean);

		verify(manageMarketDaoJpaMock).persist(
				new Market("mock name", "mock description"));

	}
}