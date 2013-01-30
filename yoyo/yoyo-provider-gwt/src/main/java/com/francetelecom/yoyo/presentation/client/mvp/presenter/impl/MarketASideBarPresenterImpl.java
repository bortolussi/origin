package com.francetelecom.yoyo.presentation.client.mvp.presenter.impl;

import com.francetelecom.yoyo.presentation.client.mvp.place.MarketAddPlace;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.MarketASideBarPresenter;
import com.francetelecom.yoyo.presentation.client.mvp.view.MarketASideBarView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * Drives {@link MarketASideBarView}. An activity in GWT 2.1 is analogous to a
 * presenter in MVP terminology. It contains all of the logic, including view
 * transition and data sync via RPCs back to the server. It contains no Widgets
 * or UI code. As a general rule, for every view you'll want a presenter to
 * drive the view and handle events that are sourced from the UI widgets within
 * the view. Activities are started and stopped by an ActivityManager associated
 * with a container Widget.
 */
public class MarketASideBarPresenterImpl extends AbstractActivity implements
		MarketASideBarPresenter {

	// managed view
	private final MarketASideBarView view;
	// In charge of the user's location in the app
	private final PlaceController placeController;

	public MarketASideBarPresenterImpl(MarketASideBarView view,
			PlaceController placeController) {
		super();
		this.view = view;
		this.placeController = placeController;
	}

	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.setPresenter(this);
		panel.setWidget(view);
	}

	public void onAddMarketClicked() {
		// go to MarketAddPlace
		placeController.goTo(new MarketAddPlace(null));
	}

}
