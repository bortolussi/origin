package com.francetelecom.yoyo.presentation.client.mvp;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.francetelecom.yoyo.presentation.client.ClientFactory;
import com.francetelecom.yoyo.presentation.client.mvp.ASideActivityMapper;
import com.francetelecom.yoyo.presentation.client.mvp.place.HomePlace;
import com.francetelecom.yoyo.presentation.client.mvp.place.MarketListPlace;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.impl.HomeASideBarPresenterImpl;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.impl.MarketASideBarPresenterImpl;

@RunWith(MockitoJUnitRunner.class)
public class NavigationActivityMapperTest {

	@Mock
	private ClientFactory clientFactory;

	private ASideActivityMapper activityMapper;

	@Before
	public void setUp() {
		activityMapper = new ASideActivityMapper(clientFactory);
	}

	@Test
	public void TestGetHomeASideBarPresenter() {
		// run operation to be tested
		// ensure operation has been called with required args
		Assert.assertTrue(activityMapper.getActivity(new HomePlace()) instanceof HomeASideBarPresenterImpl);
	}

	@Test
	public void TestGetMarketASideBarPresenter() {
		// run operation to be tested
		// ensure operation has been called with required args
		Assert.assertTrue(activityMapper.getActivity(new MarketListPlace("")) instanceof MarketASideBarPresenterImpl);
	}
}
