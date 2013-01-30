package com.francetelecom.yoyo.presentation.client.mvp.presenter;

public interface ListPresenter<D> {

	/**
	 * Action to delegate when "edit" is requested.
	 */
	void onEditClicked(D data);

	/**
	 * Action to delegate when "delete" is requested.
	 */
	void onDeleteClicked(D data);

}
