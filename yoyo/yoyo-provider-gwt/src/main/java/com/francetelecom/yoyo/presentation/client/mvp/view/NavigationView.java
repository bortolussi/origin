package com.francetelecom.yoyo.presentation.client.mvp.view;

import com.francetelecom.yoyo.presentation.client.mvp.presenter.NavigationPresenter;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * Contains all of the UI components that make up our Navigation Menu. Views are
 * responsible for the layout of the UI components.
 */
public interface NavigationView extends IsWidget {

	/**
	 * Sets home page as active.
	 */
	public void setHomePageActive();

	/**
	 * Sets market page as active.
	 */
	public void setMarketPageActive();

	/**
	 * Sets presenter that drives the view.
	 */
	void setPresenter(NavigationPresenter presenter);
}
