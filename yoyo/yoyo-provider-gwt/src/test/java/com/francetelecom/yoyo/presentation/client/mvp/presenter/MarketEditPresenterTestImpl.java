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

import com.francetelecom.yoyo.presentation.client.mvp.place.MarketListPlace;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.impl.MarketEditPresenterImpl;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.impl.MarketEditPresenterImpl.ConsultMarketCallBack;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.impl.MarketEditPresenterImpl.EditMarketCallback;
import com.francetelecom.yoyo.presentation.client.mvp.view.EditView;
import com.francetelecom.yoyo.presentation.client.rpc.ManageMarketServiceAsync;
import com.francetelecom.yoyo.model.MarketBean;
import com.francetelecom.yoyo.technicalservice.exception.InvalidMarketException;
import com.francetelecom.yoyo.technicalservice.exception.OptimisticLockingFailureException;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

@RunWith(MockitoJUnitRunner.class)
public class MarketEditPresenterTestImpl {

	@Mock
	private EditView<MarketBean> view;

	@Mock
	private ManageMarketServiceAsync service;

	@Mock
	private PlaceController placeController;

	private MarketEditPresenterImpl presenter;

	public int getMarketId() {
		return 99;
	}

	public MarketBean getMarket() {
		return new MarketBean(getMarketId(), "name", "description");
	}

	@Before
	public void setup() {
		presenter = new MarketEditPresenterImpl(view, service, placeController,
				String.valueOf(getMarketId()));
	}

	@Test
	public void testStart() {
		// run operation to be tested
		presenter.start(mock(AcceptsOneWidget.class), mock(EventBus.class));
		// ensure operation has been called with required args
		verify(service).consultMarket(eq(getMarketId()),
				isA(ConsultMarketCallBack.class));

	}

	@Test
	public void testConsultMarketCallBack() {
		// test init
		ConsultMarketCallBack callback = presenter.new ConsultMarketCallBack();
		// run operation to be tested
		callback.onSuccess(getMarket());
		// ensure operation has been called with required args
		verify(view).setData(eq(getMarket()));

	}

	@Test
	public void testConsultMarketCallBackWithFailure() {
		// test init
		ConsultMarketCallBack callback = presenter.new ConsultMarketCallBack();
		// run operation to be tested
		callback.onFailure(new Exception());
		// ensure operation has been called with required args
		verify(view).error();

	}

	@Test
	public void testStartCallBack() {
		// test init
		ConsultMarketCallBack callback = presenter.new ConsultMarketCallBack();
		// run operation to be tested
		callback.onSuccess(getMarket());
		// ensure operation has been called with required args
		verify(view).setData(eq(getMarket()));

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
		presenter.setMarket(getMarket());
		// run operation to be tested
		presenter.onSaveClicked(getMarket());
		// ensure operation has been called with required args
		verify(service).modifyMarket(eq(getMarket()),
				isA(EditMarketCallback.class));
	}

	@Test
	public void testOnSaveClickedCallBack() {
		// test init
		EditMarketCallback callback = presenter.new EditMarketCallback();
		// run operation to be tested
		callback.onSuccess(null);
		// ensure operation has been called with required args
		verify(placeController).goTo(isA(MarketListPlace.class));
	}

	@Test
	public void testOnSaveClickedCallBackWithFailure() {
		// test init
		EditMarketCallback callback = presenter.new EditMarketCallback();
		// run operation to be tested
		callback.onFailure(new Exception());
		// ensure operation has been called with required args
		verify(view).error();
	}

	@Test
	public void testOnSaveClickedCallBackWithOptimisticLockingFailureException() {
		// test init
		EditMarketCallback callback = presenter.new EditMarketCallback();
		// run operation to be tested
		callback.onFailure(new OptimisticLockingFailureException());
		// ensure operation has been called with required args
		verify(view).optimisticLockError();
	}

	@Test
	public void testOnSaveClickedCallBackWithInvalidMarketFailure() {
		// test init
		EditMarketCallback callback = presenter.new EditMarketCallback();
		// run operation to be tested
		callback.onFailure(new InvalidMarketException());
		// ensure operation has been called with required args
		verify(view).duplicateError();
	}

	@Test
	public void testOnStop() {
		// run operation to be tested
		presenter.onStop();
		// ensure operation has been called with required args
		verify(view).reset();

	}
}
