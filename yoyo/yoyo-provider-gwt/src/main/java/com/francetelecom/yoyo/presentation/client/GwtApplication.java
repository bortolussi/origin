package com.francetelecom.yoyo.presentation.client;

import com.francetelecom.yoyo.presentation.client.mvp.ASideActivityMapper;
import com.francetelecom.yoyo.presentation.client.mvp.AppPlaceHistoryMapper;
import com.francetelecom.yoyo.presentation.client.mvp.ContentActivityMapper;
import com.francetelecom.yoyo.presentation.client.mvp.FooterActivityMapper;
import com.francetelecom.yoyo.presentation.client.mvp.HeaderActivityMapper;
import com.francetelecom.yoyo.presentation.client.mvp.NavigationActivityMapper;
import com.francetelecom.yoyo.presentation.client.mvp.place.HomePlace;
import com.francetelecom.yoyo.presentation.client.resources.Constantes;
import com.francetelecom.yoyo.presentation.client.resources.Images;
import com.francetelecom.yoyo.presentation.client.resources.Messages;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * The entry point of the Gwt Application
 * 
 */
public class GwtApplication implements EntryPoint {

	// holds the application constants
	public final static Constantes constantes = GWT.create(Constantes.class);

	// holds the application messages
	public final static Messages messages = GWT.create(Messages.class);

	// holds the application images
	public final static Images images = GWT.create(Images.class);

	// using deferred binding here can be useful to get different
	// implementation classes based on user.agent or other properties
	public final static ClientFactory clientFactory = GWT
			.create(ClientFactoryImpl.class);

	public void onModuleLoad() {

		hideLoading();

		// start place
		Place startPlace = new HomePlace();

		// Warning : we have split here the main UI into several widget
		// containers (header container, content container, navigation
		// container...)
		// For each container there is an dedicated Activity Manager which is
		// responsible for handling activities lifecycle. Such practice may seem
		// quite awkward : depending on your needs you may only need a single
		// Activity Manager to drive all the activities.

		// Start ActivityManager for the header widget with our ActivityMapper
		ActivityMapper headerActivityMapper = new HeaderActivityMapper(
				clientFactory);
		ActivityManager headerActivityManager = new ActivityManager(
				headerActivityMapper, clientFactory.getEventBus());
		// display the header view in the main UI
		headerActivityManager.setDisplay(clientFactory.getSiteUI()
				.getHeaderPanel());

		// Start ActivityManager for the menu widget with our ActivityMapper
		ActivityMapper navigationActivityMapper = new NavigationActivityMapper(
				clientFactory);
		ActivityManager navigationActivityManager = new ActivityManager(
				navigationActivityMapper, clientFactory.getEventBus());
		// display the navigation view in the main UI
		navigationActivityManager.setDisplay(clientFactory.getSiteUI()
				.getMenuPanel());

		// Start ActivityManager for the content widget with our ActivityMapper
		ActivityMapper sideActivityMapper = new ASideActivityMapper(
				clientFactory);
		ActivityManager sideActivityManager = new ActivityManager(
				sideActivityMapper, clientFactory.getEventBus());
		// display the side view in the main UI
		sideActivityManager
				.setDisplay(clientFactory.getSiteUI().getSidePanel());

		// Start ActivityManager for the content widget with our ActivityMapper
		ActivityMapper contentActivityMapper = new ContentActivityMapper(
				clientFactory);
		ActivityManager contentActivityManager = new ActivityManager(
				contentActivityMapper, clientFactory.getEventBus());
		// display the content view in the main UI
		contentActivityManager.setDisplay(clientFactory.getSiteUI()
				.getContentPanel());

		// Start ActivityManager for the footer widget with our ActivityMapper
		ActivityMapper footerActivityMapper = new FooterActivityMapper(
				clientFactory);
		ActivityManager footerActivityManager = new ActivityManager(
				footerActivityMapper, clientFactory.getEventBus());
		// display the footer view in the main UI
		footerActivityManager.setDisplay(clientFactory.getSiteUI()
				.getFooterPanel());

		// Start PlaceHistoryHandler with our PlaceHistoryMapper
		AppPlaceHistoryMapper historyMapper = GWT
				.create(AppPlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(
				historyMapper);
		historyHandler.register(clientFactory.getPlaceController(),
				clientFactory.getEventBus(), startPlace);

		// add main UI at the root level
		RootLayoutPanel.get().add(clientFactory.getSiteUI());

		historyHandler.handleCurrentHistory();

	}

	/**
	 * Hides the loading message in the hosted page
	 * 
	 */
	private void hideLoading() {
		final Element loading = DOM.getElementById("loading-shadow");
		if (loading != null) {
			DOM.removeChild(RootPanel.getBodyElement(), loading);
		}
	}
}
