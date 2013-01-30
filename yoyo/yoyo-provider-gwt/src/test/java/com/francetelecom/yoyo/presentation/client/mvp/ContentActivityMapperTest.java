package com.francetelecom.yoyo.presentation.client.mvp;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.francetelecom.yoyo.presentation.client.ClientFactory;
import com.francetelecom.yoyo.presentation.client.mvp.ContentActivityMapper;
import com.francetelecom.yoyo.presentation.client.mvp.place.HomePlace;
import com.francetelecom.yoyo.presentation.client.mvp.place.MarketAddPlace;
import com.francetelecom.yoyo.presentation.client.mvp.place.MarketEditPlace;
import com.francetelecom.yoyo.presentation.client.mvp.place.MarketListPlace;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.impl.HomePresenterImpl;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.impl.MarketAddPresenterImpl;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.impl.MarketEditPresenterImpl;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.impl.MarketListPresenterImpl;

@RunWith(MockitoJUnitRunner.class)
public class ContentActivityMapperTest {

	@Mock
	private ClientFactory clientFactory;

	private ContentActivityMapper activityMapper;

	@Before
	public void setUp() {
		activityMapper = new ContentActivityMapper(clientFactory);
	}

	@Test
	public void TestGetHomePresenter() {
		// run operation to be tested
		// ensure operation has been called with required args
		Assert.assertTrue(activityMapper.getActivity(new HomePlace()) instanceof HomePresenterImpl);
	}

	@Test
	public void TestGetMarketListPresenterImpl() {
		// run operation to be tested
		// ensure operation has been called with required args
		Assert.assertTrue(activityMapper.getActivity(new MarketListPlace("")) instanceof MarketListPresenterImpl);
	}

	@Test
	public void TestGetMarketAddPresenterImpl() {
		// run operation to be tested
		// ensure operation has been called with required args
		Assert.assertTrue(activityMapper.getActivity(new MarketAddPlace("")) instanceof MarketAddPresenterImpl);
	}

	@Test
	public void TestGetMarketEditPresenterImpl() {
		// run operation to be tested
		// ensure operation has been called with required args
		Assert.assertTrue(activityMapper
				.getActivity(new MarketEditPlace("123")) instanceof MarketEditPresenterImpl);
	}
}
