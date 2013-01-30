package com.francetelecom.yoyo.presentation.client.mvp;

import com.francetelecom.yoyo.presentation.client.ClientFactory;
import com.francetelecom.yoyo.presentation.client.mvp.place.HomePlace;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.impl.HomeASideBarPresenterImpl;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.impl.MarketASideBarPresenterImpl;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;

/**
 * ASideActivityMapper maps each Place to its corresponding Activity.
 * 
 */
public class ASideActivityMapper implements ActivityMapper {

	private final ClientFactory clientFactory;

	public ASideActivityMapper(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}

	public Activity getActivity(Place place) {
		GWT.log("place :" + place);
		if (place instanceof HomePlace)
			return new HomeASideBarPresenterImpl(clientFactory.getHomeASideBarView());
		return new MarketASideBarPresenterImpl(
				clientFactory.getMarketASideBarView(),
				clientFactory.getPlaceController());
	}
}
