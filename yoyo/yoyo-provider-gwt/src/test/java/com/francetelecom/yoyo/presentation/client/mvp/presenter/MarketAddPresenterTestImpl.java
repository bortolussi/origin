package com.francetelecom.yoyo.presentation.client.mvp.presenter;

import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.francetelecom.yoyo.presentation.client.mvp.place.MarketListPlace;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.impl.MarketAddPresenterImpl;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.impl.MarketAddPresenterImpl.CreateMarketCallback;
import com.francetelecom.yoyo.presentation.client.mvp.view.EditView;
import com.francetelecom.yoyo.presentation.client.rpc.ManageMarketServiceAsync;
import com.francetelecom.yoyo.model.MarketBean;
import com.francetelecom.yoyo.technicalservice.exception.InvalidMarketException;
import com.google.gwt.place.shared.PlaceController;

@RunWith(MockitoJUnitRunner.class)
public class MarketAddPresenterTestImpl {

	@Mock
	private EditView<MarketBean> view;

	@Mock
	private ManageMarketServiceAsync service;

	@Mock
	private PlaceController placeController;

	private MarketAddPresenterImpl presenter;

	/**
	 * setup unit test
	 */
	@Before
	public void setup() {

		presenter = new MarketAddPresenterImpl(view, service, placeController);

	}

	@Test
	public void testOnCancelClicked() {
		// run operation to be tested
		presenter.onCancelClicked();
		// ensure operation has been called with required args
		verify(placeController).goTo(isA(MarketListPlace.class));
	}

	@Test
	public void testOnSaveClicked() {
		// test init
		MarketBean market = new MarketBean();
		// run operation to be tested
		presenter.onSaveClicked(market);
		// ensure operation has been called with required args
		verify(service).createMarket(eq(market),
				isA(CreateMarketCallback.class));

	}

	@Test
	public void testOnSaveClickedFailure() {
		// run operation to be tested
		presenter.onSaveClicked(null);
		// ensure operation has been called with required args
		verify(view).error();

	}

	@Test
	public void testCreateMarketCallback() {
		// test init
		CreateMarketCallback callback = presenter.new CreateMarketCallback();
		// run operation to be tested
		callback.onSuccess(null);
		// ensure operation has been called with required args
		verify(placeController).goTo(isA(MarketListPlace.class));

	}

	@Test
	public void testCreateMarketCallbackWithDuplicateMarketFailure() {
		// test init
		CreateMarketCallback callback = presenter.new CreateMarketCallback();
		// run operation to be tested
		callback.onFailure(new InvalidMarketException());
		// ensure operation has been called with required args
		verify(view).duplicateError();

	}

	@Test
	public void testCreateMarketCallbackWithFailure() {
		// test init
		CreateMarketCallback callback = presenter.new CreateMarketCallback();
		// run operation to be tested
		callback.onFailure(new Exception());
		// ensure operation has been called with required args
		verify(view).error();
	}

	@Test
	public void testOnStop() {
		// run operation to be tested
		presenter.onStop();
		// ensure operation has been called with required args
		verify(view).reset();

	}
}
