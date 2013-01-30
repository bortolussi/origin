package com.francetelecom.yoyo.presentation.client.mvp.view.impl;

import com.francetelecom.yoyo.presentation.client.GwtApplication;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.NavigationPresenter;
import com.francetelecom.yoyo.presentation.client.mvp.view.NavigationView;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.orange.gwt.clara.client.ui.UnNumberedList;

/**
 * Basic Desktop {@link NavigationView} implementation.
 */
public class NavigationViewImpl extends Composite implements NavigationView {

	private final Anchor goHome;
	private final Anchor goMarket;
	private UnNumberedList.ListItem elemGoHome;
	private UnNumberedList.ListItem elemGoMarket;
	private NavigationPresenter presenter;

	public NavigationViewImpl() {
		// go home page anchor settings
		goHome = new Anchor(GwtApplication.constantes.homeTab());
		goHome.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (presenter != null)
					presenter.onGoHomeClicked();
			}
		});
		// go market page anchor settings
		goMarket = new Anchor(GwtApplication.constantes.marketTab());
		goMarket.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (presenter != null)
					presenter.onGoMarketClicked();
			}
		});

		initWidget(getDisplay());
	}

	private Widget getDisplay() {

		// main widget is nav
		// nav contains tabElements

		// tabElement configuration - BEGIN
		UnNumberedList tabElements = new UnNumberedList();
		// elemGoHome configuration
		elemGoHome = tabElements.new ListItem();
		SimplePanel panelGoHome = new SimplePanel();
		panelGoHome.setWidget(goHome);
		elemGoHome.add(panelGoHome);
		// elemGoMarket configuration
		elemGoMarket = tabElements.new ListItem();
		SimplePanel panelGoMarket = new SimplePanel();
		panelGoMarket.setWidget(goMarket);
		elemGoMarket.add(panelGoMarket);
		tabElements.add(elemGoHome);
		tabElements.add(elemGoMarket);
		// tabElement configuration - END

		// nav bar configuration
		FlowPanel nav = new FlowPanel();
		nav.getElement().setId("nav");
		nav.add(tabElements);

		//
		setHomePageActive();

		return nav;
	}

	public void setHomePageActive() {
		elemGoHome.setStylePrimaryName("active");
		elemGoMarket.setStylePrimaryName("inactive");
	}

	public void setMarketPageActive() {
		elemGoHome.setStylePrimaryName("inactive");
		elemGoMarket.setStylePrimaryName("active");
	}

	public void setPresenter(NavigationPresenter presenter) {
		this.presenter = presenter;

	}

}
