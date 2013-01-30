package com.francetelecom.yoyo.presentation.client.mvp;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.francetelecom.yoyo.presentation.client.ClientFactory;
import com.francetelecom.yoyo.presentation.client.mvp.HeaderActivityMapper;
import com.francetelecom.yoyo.presentation.client.mvp.place.HomePlace;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.impl.HeaderPresenterImpl;

@RunWith(MockitoJUnitRunner.class)
public class HeaderActivityMapperTest {

	@Mock
	private ClientFactory clientFactory;

	private HeaderActivityMapper activityMapper;

	@Before
	public void setUp() {
		activityMapper = new HeaderActivityMapper(clientFactory);
	}

	@Test
	public void TestGetHeaderPresenter() {
		// run operation to be tested
		// ensure operation has been called with required args
		Assert.assertTrue(activityMapper.getActivity(new HomePlace()) instanceof HeaderPresenterImpl);
	}

}
