package com.francetelecom.yoyo.presentation.client.mvp.presenter.impl;

import java.util.ArrayList;
import java.util.Map;

import com.francetelecom.yoyo.presentation.client.mvp.place.MarketEditPlace;
import com.francetelecom.yoyo.presentation.client.mvp.place.MarketListPlace;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.ListPresenter;
import com.francetelecom.yoyo.presentation.client.mvp.view.ListView;
import com.francetelecom.yoyo.presentation.client.rpc.ManageMarketServiceAsync;
import com.francetelecom.yoyo.model.MarketBean;
import com.francetelecom.yoyo.technicalservice.exception.NotFoundException;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * Drives {@link ListView}. An activity in GWT 2.1 is analogous to a presenter
 * in MVP terminology. It contains all of the logic, including view transition
 * and data sync via RPCs back to the server. It contains no Widgets or UI code.
 * As a general rule, for every view you'll want a presenter to drive the view
 * and handle events that are sourced from the UI widgets within the view.
 * Activities are started and stopped by an ActivityManager associated with a
 * container Widget.
 */
public class MarketListPresenterImpl extends AbstractActivity implements
		ListPresenter<MarketBean> {

	// managed view
	private final ListView<MarketBean> view;
	// In charge of the user's location in the app
	private final PlaceController placeController;
	// RPC service proxy
	private final ManageMarketServiceAsync manageMarketServiceProxy;

	public MarketListPresenterImpl(ListView<MarketBean> view,
			ManageMarketServiceAsync serviceProxy,
			PlaceController placeController) {
		super();
		this.view = view;
		this.manageMarketServiceProxy = serviceProxy;
		this.placeController = placeController;
	}

	public void start(AcceptsOneWidget panel, final EventBus eventBus) {
		view.setPresenter(this);
		view.reset();
		// call rpc service to fetch all the markets
		manageMarketServiceProxy.findAllMarkets(new FindAllMarketsCallBack());
		panel.setWidget(view);

	}

	public void onEditClicked(MarketBean marketBean) {
		placeController.goTo(new MarketEditPlace(String.valueOf(marketBean
				.getId())));

	}

	public void onDeleteClicked(MarketBean marketBean) {
		// the user needs to confirm market deletion
		if (!view.confirmDeletion(marketBean)) {
			return;
		}
		// call rpc service to delete the market
		manageMarketServiceProxy.deleteMarket(marketBean.getId(),
				new DeleteMarketCallBack());

	}

	public class FindAllMarketsCallBack implements
			AsyncCallback<Map<Integer, MarketBean>> {

		public void onFailure(Throwable caught) {
			if (caught instanceof NotFoundException) {
				view.noData();
			} else {
				GWT.log("a technical exception has occured: " + caught);
				view.error();
			}

		}

		public void onSuccess(Map<Integer, MarketBean> result) {
			view.setData(new ArrayList<MarketBean>(result.values()));
		}

	}

	public class DeleteMarketCallBack implements AsyncCallback<Void> {

		public void onFailure(Throwable caught) {
			GWT.log("a technical exception has occured during deletion: "
					+ caught);
			view.error();

		}

		public void onSuccess(Void result) {
			GWT.log("market is deleted");
			// go to MarketListPlace
			placeController.goTo(new MarketListPlace(null));

		}

	}

}
