package com.francetelecom.yoyo.presentation.client.mvp;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.francetelecom.yoyo.presentation.client.ClientFactory;
import com.francetelecom.yoyo.presentation.client.mvp.FooterActivityMapper;
import com.francetelecom.yoyo.presentation.client.mvp.place.HomePlace;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.impl.FooterPresenterImpl;

@RunWith(MockitoJUnitRunner.class)
public class FooterActivityMapperTest {

	@Mock
	private ClientFactory clientFactory;

	private FooterActivityMapper activityMapper;

	@Before
	public void setUp() {
		activityMapper = new FooterActivityMapper(clientFactory);
	}

	@Test
	public void TestGetFooterPresenter() {
		// run operation to be tested
		// ensure operation has been called with required args
		Assert.assertTrue(activityMapper.getActivity(new HomePlace()) instanceof FooterPresenterImpl);
	}

}
