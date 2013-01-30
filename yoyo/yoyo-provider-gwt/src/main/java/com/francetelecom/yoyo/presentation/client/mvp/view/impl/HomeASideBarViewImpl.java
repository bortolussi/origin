package com.francetelecom.yoyo.presentation.client.mvp.view.impl;

import com.francetelecom.yoyo.presentation.client.GwtApplication;
import com.francetelecom.yoyo.presentation.client.mvp.view.HomeASideBarView;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

/**
 * Basic Desktop {@link HomeASideBarView} implementation.
 */
public class HomeASideBarViewImpl extends Composite implements HomeASideBarView {

	private final Image background;

	public HomeASideBarViewImpl() {

		// home background image settings
		background = new Image(GwtApplication.images.homeBckgrnd());

		initWidget(getDisplay());

	}

	private Widget getDisplay() {

		// main widget is subnav panel
		FlowPanel subnav = new FlowPanel();
		subnav.getElement().setId("subnav");
		subnav.add(background);

		return subnav;

	}
}
