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

import com.francetelecom.yoyo.presentation.client.mvp.place.MarketAddPlace;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.impl.MarketASideBarPresenterImpl;
import com.francetelecom.yoyo.presentation.client.mvp.view.MarketASideBarView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

@RunWith(MockitoJUnitRunner.class)
public class MarketASideBarPresenterImplTest {

	@Mock
	private MarketASideBarView view;

	@Mock
	private AcceptsOneWidget parent;

	@Mock
	private PlaceController placeController;

	private MarketASideBarPresenterImpl presenter;

	@Before
	public void setUp() {
		presenter = new MarketASideBarPresenterImpl(view, placeController);
	}

	@Test
	public void testStartActivity() {
		// run operation to be tested
		presenter.start(parent, mock(EventBus.class));
		// ensure operation has been called with required args
		verify(view).setPresenter(eq(presenter));
		verify(parent).setWidget(eq(view));
	}

	@Test
	public void testOnAddMarketClicked() {
		// run operation to be tested
		presenter.onAddMarketClicked();
		// ensure operation has been called with required args
		verify(placeController).goTo(isA(MarketAddPlace.class));
	}
}
