package com.francetelecom.yoyo.presentation.client.mvp.presenter.impl;

import com.francetelecom.yoyo.presentation.client.mvp.view.HeaderView;
import com.francetelecom.yoyo.presentation.client.rpc.ManageMarketServiceAsync;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * Drives {@link HeaderView}. An activity in GWT 2.1 is analogous to a presenter
 * in MVP terminology. It contains all of the logic, including view transition
 * and data sync via RPCs back to the server. It contains no Widgets or UI code.
 * As a general rule, for every view you'll want a presenter to drive the view
 * and handle events that are sourced from the UI widgets within the view.
 * Activities are started and stopped by an ActivityManager associated with a
 * container Widget.
 */
public class HeaderPresenterImpl extends AbstractActivity {

	// managed view
	private final HeaderView view;
	// RPC service proxy
	private final ManageMarketServiceAsync manageMarketServiceProxy;

	public HeaderPresenterImpl(HeaderView view, ManageMarketServiceAsync serviceProxy) {
		this.view = view;
		this.manageMarketServiceProxy = serviceProxy;
	}

	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		panel.setWidget(view);
		manageMarketServiceProxy.getUserLogin(new GetUserLoginCallBack());
	}

	/**
	 * Handles RPC callback. Useful for unit testing.
	 */
	public class GetUserLoginCallBack implements AsyncCallback<String> {

		public void onFailure(Throwable caught) {
			view.error();
		}

		public void onSuccess(String login) {
			view.setUserLogin(login);
		}

	}
}
