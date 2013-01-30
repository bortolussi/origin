package com.francetelecom.yoyo.presentation.client.mvp.presenter.impl;

import com.francetelecom.yoyo.presentation.client.mvp.place.HomePlace;
import com.francetelecom.yoyo.presentation.client.mvp.place.MarketListPlace;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.NavigationPresenter;
import com.francetelecom.yoyo.presentation.client.mvp.view.NavigationView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * Drives {@link NavigationView}. An activity in GWT 2.1 is analogous to a
 * presenter in MVP terminology. It contains all of the logic, including view
 * transition and data sync via RPCs back to the server. It contains no Widgets
 * or UI code. As a general rule, for every view you'll want a presenter to
 * drive the view and handle events that are sourced from the UI widgets within
 * the view. Activities are started and stopped by an ActivityManager associated
 * with a container Widget.
 */
public class NavigationPresenterImpl extends AbstractActivity implements
		NavigationPresenter {

	// managed view
	private final NavigationView view;
	// In charge of the user's location in the app
	private final PlaceController placeController;
	// which navigation tab should be selected : HOME, MARKET .....
	private final NavigationState state;

	public NavigationPresenterImpl(NavigationView view,
			PlaceController placeController, NavigationState state) {
		super();
		this.view = view;
		this.state = state;
		this.placeController = placeController;
	}

	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.setPresenter(this);
		switch (state) {
		case HOME:
			view.setHomePageActive();
			break;
		default:
			view.setMarketPageActive();
			break;
		}
		panel.setWidget(view);
	}

	public void onGoHomeClicked() {
		// go to HomePlace
		placeController.goTo(new HomePlace());
	}

	public void onGoMarketClicked() {
		// go to MarketListPlace
		placeController.goTo(new MarketListPlace(null));
	}
}
