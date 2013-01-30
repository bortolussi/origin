package com.francetelecom.yoyo.presentation.client.mvp.view;

import com.google.gwt.user.client.ui.IsWidget;

/**
 * Contains all of the UI components that make up our Header. Views are
 * responsible for the layout of the UI components.
 */
public interface HeaderView extends IsWidget {

	/**
	 * Sets user login into the view.
	 */
	public void setUserLogin(String login);

	/**
	 * Shows error feedback.
	 */
	public void error();

}
