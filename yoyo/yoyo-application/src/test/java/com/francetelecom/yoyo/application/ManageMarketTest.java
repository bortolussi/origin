package com.francetelecom.yoyo.application;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.francetelecom.yoyo.application.impl.ManageMarketImpl;
import com.francetelecom.yoyo.business.ManageMarketBusiness;
import com.francetelecom.yoyo.model.MarketBean;
import com.francetelecom.yoyo.technicalservice.exception.InvalidMarketException;
import com.francetelecom.yoyo.technicalservice.exception.NotFoundException;
import com.francetelecom.yoyo.technicalservice.exception.TechnicalException;

public class ManageMarketTest {

	private ManageMarketImpl manageMarket;

	private ManageMarketBusiness manageMarketBusinessMock;

	/**
	 * setup unit test
	 */
	@Before
	public void setup() {
		// Application layer class to be tested
		manageMarket = new ManageMarketImpl();

		// Business layer class mock
		manageMarketBusinessMock = mock(ManageMarketBusiness.class,
				"ManageMarketBusiness Mock");

		// dependency injection
		manageMarket.setManageMarketBusiness(manageMarketBusinessMock);
	}

	/**
	 * Test method for searching markets
	 * 
	 * @see com.francetelecom.yoyo.application.ManageMarket#findAllMarkets
	 */
	@Test
	public void testFindAllMarkets() throws NotFoundException,
			TechnicalException {
		// setup
		MarketBean market1 = new MarketBean(1, "name1", "description1");
		MarketBean market2 = new MarketBean(2, "name2", "description2");
		MarketBean market3 = new MarketBean(3, "name3", "description3");
		Map<Integer, MarketBean> listMock = new HashMap<Integer, MarketBean>();
		listMock.put(1, market1);
		listMock.put(2, market2);
		listMock.put(2, market3);

		when(manageMarketBusinessMock.findAllMarkets()).thenReturn(listMock);

		// execution
		Map<Integer, MarketBean> resultList = manageMarket.findAllMarkets();

		// verification
		assertNotNull(resultList);
		// TODO : verify Map content
		assertEquals("findAllMarkets", listMock, resultList);
	}

	/**
	 * Test method for empty market List
	 * 
	 * @see com.francetelecom.yoyo.application.ManageMarket#findAllMarkets()
	 */
	@Test(expected = NotFoundException.class)
	public void testFindAllMarketsEmpty() throws NotFoundException,
			TechnicalException {
		// setup
		when(manageMarketBusinessMock.findAllMarkets()).thenThrow(
				new NotFoundException("No market found"));

		// execution
		manageMarket.findAllMarkets();
	}

	/**
	 * Test method for market creation
	 * 
	 * @see com.francetelecom.yoyo.application.ManageMarket#createMarket(MarketBean)
	 */
	@Test
	public void testCreateMarket() throws InvalidMarketException,
			TechnicalException {

		MarketBean market = new MarketBean(123, "mock name", "mock description");

		manageMarket.createMarket(market);

		verify(manageMarketBusinessMock).createMarket(market);
	}
}