package com.francetelecom.yoyo.presentation.client.mvp.view.impl;

import com.francetelecom.yoyo.presentation.client.GwtApplication;
import com.francetelecom.yoyo.presentation.client.mvp.view.HomeView;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

/**
 * Basic Desktop {@link HomeView} implementation.
 */
public class HomeViewImpl extends Composite implements HomeView {

	private final HTML title;
	private final HTML textContent;

	public HomeViewImpl() {
		// home page title settings
		title = new HTML("<h2>" + GwtApplication.constantes.homePage_title()
				+ "</h2>");
		// home page text content settings
		textContent = new HTML(GwtApplication.constantes.homePage_content());
		textContent.setStylePrimaryName("brand-txt-wide");

		initWidget(getDisplay());

	}

	private Widget getDisplay() {

		// main widget is main panel
		// main panel contains content panel

		// content panel configuration
		FlowPanel content = new FlowPanel();
		content.getElement().setId("content");
		content.add(title);
		content.add(textContent);

		return content;

	}
}
