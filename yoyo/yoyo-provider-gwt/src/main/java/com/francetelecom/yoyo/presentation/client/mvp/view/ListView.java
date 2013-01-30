package com.francetelecom.yoyo.presentation.client.mvp.view;

import java.util.List;

import com.francetelecom.yoyo.presentation.client.mvp.presenter.ListPresenter;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * Contains all of the UI components that make up our List Page. Views are
 * responsible for the layout of the UI components.
 */
public interface ListView<D> extends IsWidget {

	/**
	 * Sets data into the view.
	 */
	public void setData(List<D> data);

	/**
	 * Sets empty data into the view.
	 */
	public void noData();

	/**
	 * Resets view.
	 */
	public void reset();

	/**
	 * Shows error feedback.
	 */
	public void error();

	/**
	 * Asks the user to confirm deletion.
	 */
	public boolean confirmDeletion(D data);

	/**
	 * Sets presenter that drives the view.
	 */
	void setPresenter(ListPresenter<D> presenter);
}
