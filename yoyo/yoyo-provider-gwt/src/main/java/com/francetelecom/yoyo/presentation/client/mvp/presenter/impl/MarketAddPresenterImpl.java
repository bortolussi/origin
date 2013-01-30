package com.francetelecom.yoyo.presentation.client.mvp.presenter.impl;

import com.francetelecom.yoyo.presentation.client.GwtApplication;
import com.francetelecom.yoyo.presentation.client.mvp.place.MarketListPlace;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.EditPresenter;
import com.francetelecom.yoyo.presentation.client.mvp.view.EditView;
import com.francetelecom.yoyo.presentation.client.rpc.ManageMarketServiceAsync;
import com.francetelecom.yoyo.model.MarketBean;
import com.francetelecom.yoyo.technicalservice.exception.InvalidMarketException;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * Drives {@link EditView}. An activity in GWT 2.1 is analogous to a presenter
 * in MVP terminology. It contains all of the logic, including view transition
 * and data sync via RPCs back to the server. It contains no Widgets or UI code.
 * As a general rule, for every view you'll want a presenter to drive the view
 * and handle events that are sourced from the UI widgets within the view.
 * Activities are started and stopped by an ActivityManager associated with a
 * container Widget.
 */
public class MarketAddPresenterImpl implements EditPresenter<MarketBean> {

	// managed view
	private final EditView<MarketBean> view;
	// In charge of the user's location in the app
	private final PlaceController placeController;
	// RPC service proxy
	private final ManageMarketServiceAsync manageMarketServiceProxy;
	// waiting flag to warn ourselves we are waiting for a rpc response
	private boolean waiting = false;
	// saved flag to warn ourselves that no data creation has been flushed to
	// the server
	private boolean flushed = false;

	public MarketAddPresenterImpl(EditView<MarketBean> view,
			ManageMarketServiceAsync serviceProxy,
			PlaceController placeController) {
		super();
		this.view = view;
		this.placeController = placeController;
		this.manageMarketServiceProxy = serviceProxy;
	}

	public void start(AcceptsOneWidget panel, final EventBus eventBus) {
		view.setPresenter(this);
		// we are in creating mode
		view.setCreating(true);
		// view should contain no data
		view.setData(null);

		panel.setWidget(view);
	}

	public void onCancelClicked() {
		// go to MarketListPlace
		placeController.goTo(new MarketListPlace(null));
	}

	/**
	 * @return true if we're waiting for an rpc response.
	 */
	private boolean isWaiting() {
		return waiting;
	}

	/**
	 * We set the waiting flag to warn ourselves we are waiting for a rpc
	 * response.
	 */
	private void setWaiting(boolean wait) {
		this.waiting = wait;
	}

	/**
	 * @return true if data creation has been flushed to the server.
	 */
	private boolean isFlushed() {
		return flushed;
	}

	/**
	 * We set the flushed flag to warn ourselves that no data creation has been
	 * flushed to the server
	 */
	private void setFlushed(boolean flush) {
		this.flushed = flush;
	}

	/**
	 * @return true if data has been edited.
	 */
	private boolean changed() {
		return !view.noData();
	}

	public void onSaveClicked(MarketBean data) {
		if (data != null) {
			// we are waiting for a rpc response
			setWaiting(true);
			manageMarketServiceProxy.createMarket(data,
					new CreateMarketCallback());
		} else {
			GWT.log("a technical exception has occured: market to be added is null");
			view.error();
		}

	}

	/**
	 * Called when the user is trying to navigate away from this activity.
	 * 
	 * @return A message to display to the user, e.g. to warn of unsaved work,
	 *         or null to say nothing
	 */
	public String mayStop() {
		GWT.log("isWaiting?:" + isWaiting());
		GWT.log("changed?:" + changed());
		if (isWaiting() || (!isFlushed() && changed())) {
			return GwtApplication.constantes.edit_cancel_confirm();
		}
		return null;
	}

	public void onCancel() {
	}

	public void onStop() {
		// view could be re used because it is a singleton
		view.reset();
	}

	/**
	 * Handles RPC callback. Useful for unit testing.
	 */
	public class CreateMarketCallback implements AsyncCallback<Integer> {

		public void onFailure(Throwable caught) {
			// we are no more waiting for a rpc response
			setWaiting(false);
			if (caught instanceof InvalidMarketException) {
				view.duplicateError();
			} else {
				GWT.log("a technical exception has occured: " + caught);
				view.error();
			}

		}

		public void onSuccess(Integer result) {
			GWT.log("market is created");
			// we are no more waiting for a rpc response
			setWaiting(false);
			// data creation has been flushed to the server
			setFlushed(true);
			// go to MarketListPlace
			placeController.goTo(new MarketListPlace(null));
		}

	}
}
