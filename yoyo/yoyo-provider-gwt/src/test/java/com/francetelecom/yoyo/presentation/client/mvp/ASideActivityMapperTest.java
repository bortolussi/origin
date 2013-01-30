package com.francetelecom.yoyo.presentation.client.mvp;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.francetelecom.yoyo.presentation.client.ClientFactory;
import com.francetelecom.yoyo.presentation.client.mvp.NavigationActivityMapper;
import com.francetelecom.yoyo.presentation.client.mvp.place.HomePlace;
import com.francetelecom.yoyo.presentation.client.mvp.place.MarketListPlace;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.impl.NavigationPresenterImpl;

@RunWith(MockitoJUnitRunner.class)
public class ASideActivityMapperTest {

	@Mock
	private ClientFactory clientFactory;

	private NavigationActivityMapper activityMapper;

	@Before
	public void setUp() {
		activityMapper = new NavigationActivityMapper(clientFactory);
	}

	@Test
	public void TestGetNavigationPresenter_HOME() {
		// run operation to be tested
		// ensure operation has been called with required args
		Assert.assertTrue(activityMapper.getActivity(new HomePlace()) instanceof NavigationPresenterImpl);
	}

	@Test
	public void TestGetNavigationPresenter_MARKET() {
		// run operation to be tested
		// ensure operation has been called with required args
		Assert.assertTrue(activityMapper.getActivity(new MarketListPlace("")) instanceof NavigationPresenterImpl);
	}
}
