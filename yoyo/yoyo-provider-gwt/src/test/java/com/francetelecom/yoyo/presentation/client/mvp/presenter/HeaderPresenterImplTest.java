package com.francetelecom.yoyo.presentation.client.mvp.presenter;

import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.francetelecom.yoyo.presentation.client.mvp.presenter.impl.HeaderPresenterImpl;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.impl.HeaderPresenterImpl.GetUserLoginCallBack;
import com.francetelecom.yoyo.presentation.client.mvp.view.HeaderView;
import com.francetelecom.yoyo.presentation.client.rpc.ManageMarketServiceAsync;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

@RunWith(MockitoJUnitRunner.class)
public class HeaderPresenterImplTest {

	@Mock
	private HeaderView view;

	@Mock
	private AcceptsOneWidget parent;

	@Mock
	private ManageMarketServiceAsync service;

	private HeaderPresenterImpl presenter;

	private String getUserLogin() {
		return "adm";
	}

	@Before
	public void setUp() {
		presenter = new HeaderPresenterImpl(view, service);
	}

	@Test
	public void testStartActivity() {
		// run operation to be tested
		presenter.start(parent, mock(EventBus.class));
		// ensure operation has been called with required args
		verify(parent).setWidget(eq(view));
		// FIXME check service call parameters
		verify(service).getUserLogin(isA(GetUserLoginCallBack.class));
	}

	@Test
	public void testGetUserLoginCallBack() {
		// test init
		GetUserLoginCallBack callBack = presenter.new GetUserLoginCallBack();
		// run operation to be tested
		callBack.onSuccess(getUserLogin());
		// ensure operation has been called with required args
		verify(view).setUserLogin(eq(getUserLogin()));
	}

	@Test
	public void testGetUserLoginCallBackWithFailure() {
		// test init
		GetUserLoginCallBack callBack = presenter.new GetUserLoginCallBack();
		// run operation to be tested
		callBack.onFailure(new Exception());
		// ensure operation has been called with required args
		verify(view).error();
	}
}
