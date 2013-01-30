package com.francetelecom.yoyo.presentation.client.mvp.presenter.impl;

import com.francetelecom.yoyo.presentation.client.mvp.view.FooterView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * Drives {@link FooterView}. An activity in GWT 2.1 is analogous to a presenter
 * in MVP terminology. It contains all of the logic, including view transition
 * and data sync via RPCs back to the server. It contains no Widgets or UI code.
 * As a general rule, for every view you'll want a presenter to drive the view
 * and handle events that are sourced from the UI widgets within the view.
 * Activities are started and stopped by an ActivityManager associated with a
 * container Widget.
 */
public class FooterPresenterImpl extends AbstractActivity {

	// managed view
	private final FooterView view;

	public FooterPresenterImpl(FooterView view) {
		super();
		this.view = view;
	}

	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		// display view in UI
		panel.setWidget(view);
	}

}
