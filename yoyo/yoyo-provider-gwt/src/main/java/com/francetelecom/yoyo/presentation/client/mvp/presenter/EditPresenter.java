package com.francetelecom.yoyo.presentation.client.mvp.presenter;

import com.google.gwt.activity.shared.Activity;

/**
 * Implemented by the activity which drives the view.
 */
public interface EditPresenter<D> extends Activity {

	/**
	 * Action to delegate when "save" is required.
	 */
	void onSaveClicked(D data);

	/**
	 * Action to delegate when "cancel" is required.
	 */
	void onCancelClicked();
}