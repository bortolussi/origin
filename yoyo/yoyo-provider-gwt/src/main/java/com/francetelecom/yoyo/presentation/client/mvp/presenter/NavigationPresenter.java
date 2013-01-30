package com.francetelecom.yoyo.presentation.client.mvp.presenter;

public interface NavigationPresenter {

	/**
	 * Action to delegate when "go to home page" is requested.
	 */
	void onGoHomeClicked();

	/**
	 * Action to delegate when "go to market page" is requested.
	 */
	void onGoMarketClicked();
}
