package com.francetelecom.yoyo.presentation.client.mvp.presenter;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.francetelecom.yoyo.presentation.client.mvp.place.HomePlace;
import com.francetelecom.yoyo.presentation.client.mvp.place.MarketListPlace;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.impl.NavigationPresenterImpl;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.impl.NavigationState;
import com.francetelecom.yoyo.presentation.client.mvp.view.NavigationView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

@RunWith(MockitoJUnitRunner.class)
public class NavigationPresenterTestImpl {

	@Mock
	private NavigationView view;

	@Mock
	private PlaceController placeController;

	@Test
	public void testStartWithHomeTab() {
		// test init
		NavigationPresenterImpl presenter = new NavigationPresenterImpl(view,
				placeController, NavigationState.HOME);
		// run operation to be tested
		presenter.start(mock(AcceptsOneWidget.class), mock(EventBus.class));
		// ensure operation has been called with required args
		verify(view).setHomePageActive();
	}

	@Test
	public void testStartWithMarketTab() {
		// test init
		NavigationPresenterImpl presenter = new NavigationPresenterImpl(view,
				placeController, NavigationState.MARKET);
		// run operation to be tested
		presenter.start(mock(AcceptsOneWidget.class), mock(EventBus.class));
		// ensure operation has been called with required args
		verify(view).setMarketPageActive();
	}

	@Test
	public void onGoHomeClicked() {
		// test init
		NavigationPresenterImpl presenter = new NavigationPresenterImpl(view,
				placeController, NavigationState.HOME);
		// run operation to be tested
		presenter.onGoHomeClicked();
		// ensure operation has been called with required args
		verify(placeController).goTo(isA(HomePlace.class));
	}

	@Test
	public void onGoMarketClicked() {
		// test init
		NavigationPresenterImpl presenter = new NavigationPresenterImpl(view,
				placeController, NavigationState.HOME);
		// run operation to be tested
		presenter.onGoMarketClicked();
		// ensure operation has been called with required args
		verify(placeController).goTo(isA(MarketListPlace.class));
	}

}
