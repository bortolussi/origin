package com.francetelecom.yoyo.presentation.client.mvp.view;

import com.francetelecom.yoyo.presentation.client.mvp.presenter.MarketASideBarPresenter;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * Contains all of the UI components that make up our MarketASide Bar. Views are
 * responsible for the layout of the UI components.
 */
public interface MarketASideBarView extends IsWidget {

	/**
	 * Sets presenter that drives the view.
	 */
	public void setPresenter(MarketASideBarPresenter presenter);

}
