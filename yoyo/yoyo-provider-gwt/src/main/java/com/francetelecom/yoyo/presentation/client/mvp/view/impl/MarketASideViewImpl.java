package com.francetelecom.yoyo.presentation.client.mvp.view.impl;

import com.francetelecom.yoyo.presentation.client.GwtApplication;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.MarketASideBarPresenter;
import com.francetelecom.yoyo.presentation.client.mvp.view.MarketASideBarView;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.orange.gwt.clara.client.ui.UnNumberedList;

/**
 * Basic Desktop {@link MarketASideBarView} implementation.
 */
public class MarketASideViewImpl extends Composite implements
		MarketASideBarView {

	private final Anchor doCreate;
	private MarketASideBarPresenter presenter;

	public MarketASideViewImpl() {
		super();

		// create anchor settings
		doCreate = new Anchor(GwtApplication.constantes.marketPage_create());
		doCreate.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				// requests action from presenter
				if (presenter != null)
					presenter.onAddMarketClicked();
			}
		});

		initWidget(getDisplay());

	}

	private Widget getDisplay() {

		// holds side bar available actions
		UnNumberedList list = new UnNumberedList();
		// List element configuration
		UnNumberedList.ListItem addAMarket = list.new ListItem();
		addAMarket.add(doCreate);

		list.add(addAMarket);

		FlowPanel subnav = new FlowPanel();
		subnav.getElement().setId("subnav");
		subnav.add(list);

		return subnav;

	}

	public void setPresenter(MarketASideBarPresenter presenter) {
		this.presenter = presenter;
	}

}
