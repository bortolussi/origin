package com.francetelecom.yoyo.presentation.client.mvp.view;

import com.francetelecom.yoyo.presentation.client.mvp.presenter.EditPresenter;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * Contains all of the UI components that make up our Edit Pages. Views are
 * responsible for the layout of the UI components.
 */
public interface EditView<D> extends IsWidget {

	/**
	 * Sets data into the view.
	 */
	public void setData(D data);

	/**
	 * Gets data from the view.
	 */
	public D getData();

	/**
	 * @return true if view contains no data.
	 */
	public boolean noData();

	/**
	 * Resets data in view.
	 */
	public void reset();

	/**
	 * Sets if mode is creation.
	 */
	public void setCreating(boolean creating);

	/**
	 * Shows error feedback.
	 */
	public void error();

	/**
	 * Shows optimistic lock error feedback.
	 */
	public void optimisticLockError();

	/**
	 * Shows deletion error feedback.
	 */
	public void deletionError();

	/**
	 * Shows duplicate error feedback.
	 */
	public void duplicateError();

	/**
	 * Sets presenter that drives the view.
	 */
	public void setPresenter(EditPresenter<D> presenter);

}
