package com.francetelecom.yoyo.presentation.client.mvp.presenter;

import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.francetelecom.yoyo.presentation.client.mvp.place.MarketEditPlace;
import com.francetelecom.yoyo.presentation.client.mvp.place.MarketListPlace;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.impl.MarketListPresenterImpl;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.impl.MarketListPresenterImpl.DeleteMarketCallBack;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.impl.MarketListPresenterImpl.FindAllMarketsCallBack;
import com.francetelecom.yoyo.presentation.client.mvp.view.ListView;
import com.francetelecom.yoyo.presentation.client.rpc.ManageMarketServiceAsync;
import com.francetelecom.yoyo.model.MarketBean;
import com.francetelecom.yoyo.technicalservice.exception.NotFoundException;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

@RunWith(MockitoJUnitRunner.class)
public class MarketListPresenterImplTest {

	@Mock
	private ListView<MarketBean> view;

	@Mock
	private ManageMarketServiceAsync service;

	@Mock
	private PlaceController placeController;

	private MarketListPresenterImpl presenter;

	public int getMarketId() {
		return 99;
	}

	public MarketBean getMarket() {
		return new MarketBean(getMarketId(), "name", "description");
	}

	@Before
	public void setup() {
		presenter = new MarketListPresenterImpl(view, service, placeController);

	}

	@Test
	public void testStartActivity() {
		// run operation to be tested
		presenter.start(mock(AcceptsOneWidget.class), mock(EventBus.class));
		// ensure operation has been called with required args
		verify(service).findAllMarkets(isA(FindAllMarketsCallBack.class));
	}

	@Test
	public void testStartCallBack() {
		// test init
		MarketBean market98 = new MarketBean(98, "name98", "description98");
		MarketBean market99 = new MarketBean(99, "name99", "description99");
		Map<Integer, MarketBean> markets = new HashMap<Integer, MarketBean>();
		markets.put(market98.getId(), market98);
		markets.put(market99.getId(), market99);
		FindAllMarketsCallBack callback = presenter.new FindAllMarketsCallBack();
		// run operation to be tested
		callback.onSuccess(markets);
		// ensure operation has been called with required args
		verify(view).setData(eq(new ArrayList<MarketBean>(markets.values())));
	}

	@Test
	public void testStartCallBackWithFailure() {
		// test init
		FindAllMarketsCallBack callback = presenter.new FindAllMarketsCallBack();
		// run operation to be tested
		callback.onFailure(new Exception());
		// ensure operation has been called with required args
		verify(view).error();
	}

	@Test
	public void testStartCallBackWithNoDataFailure() {
		// test init
		FindAllMarketsCallBack callback = presenter.new FindAllMarketsCallBack();
		// run operation to be tested
		callback.onFailure(new NotFoundException());
		// ensure operation has been called with required args
		verify(view).noData();
	}

	@Test
	public void testOnEditClicked() {
		// run operation to be tested
		presenter.onEditClicked(getMarket());
		// ensure operation has been called with required args
		// FIXME test incomplet : voir comment on peut tester que le marketId
		// est bien pass� en parmetre
		verify(placeController).goTo(isA(MarketEditPlace.class));
	}

	@Test
	public void testOnDeleteClicked() {
		// configure mock behavior
		when(view.confirmDeletion(getMarket())).thenReturn(true);
		// run operation to be tested
		presenter.onDeleteClicked(getMarket());
		// ensure operation has been called with required args
		verify(view).confirmDeletion(getMarket());
		// ensure operation has been called with required args
		verify(service).deleteMarket(eq(getMarketId()),
				isA(DeleteMarketCallBack.class));
	}

	@Test
	public void testOnCancelAfterDeleteClicked() {
		// configure mock behavior
		when(view.confirmDeletion(getMarket())).thenReturn(false);
		// run operation to be tested
		presenter.onDeleteClicked(getMarket());
		// ensure operation has been called with required args
		verify(view).confirmDeletion(getMarket());
		// ensure operation has been called with required args
		verify(service, never()).deleteMarket(eq(getMarketId()),
				isA(DeleteMarketCallBack.class));
	}

	@Test
	public void testOnDeleteClickedCallBack() {
		// test init
		DeleteMarketCallBack callback = presenter.new DeleteMarketCallBack();
		Void result = null;
		// run operation to be tested
		callback.onSuccess(result);
		// ensure operation has been called with required args
		verify(placeController).goTo(isA(MarketListPlace.class));
	}

	@Test
	public void testOnDeleteClickedCallBackWithFailure() {
		// test init
		DeleteMarketCallBack callback = presenter.new DeleteMarketCallBack();
		// run operation to be tested
		callback.onFailure(new Exception());
		// ensure operation has been called with required args
		verify(view).error();
	}

}
