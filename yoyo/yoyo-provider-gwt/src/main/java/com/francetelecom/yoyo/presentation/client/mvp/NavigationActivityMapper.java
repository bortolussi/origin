package com.francetelecom.yoyo.presentation.client.mvp;

import com.francetelecom.yoyo.presentation.client.ClientFactory;
import com.francetelecom.yoyo.presentation.client.mvp.place.HomePlace;
import com.francetelecom.yoyo.presentation.client.mvp.place.MarketListPlace;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.impl.NavigationPresenterImpl;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.impl.NavigationState;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

/**
 * NavigationActivityMapper maps each Place to its corresponding Activity.
 * 
 */
public class NavigationActivityMapper implements ActivityMapper {

	private final ClientFactory clientFactory;

	public NavigationActivityMapper(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}

	public Activity getActivity(Place place) {
		if (place instanceof HomePlace)
			return new NavigationPresenterImpl(clientFactory.getNavigationView(),
					clientFactory.getPlaceController(), NavigationState.HOME);
		if (place instanceof MarketListPlace)
			return new NavigationPresenterImpl(clientFactory.getNavigationView(),
					clientFactory.getPlaceController(), NavigationState.MARKET);
		return new NavigationPresenterImpl(clientFactory.getNavigationView(),
				clientFactory.getPlaceController(), NavigationState.OTHER);
	}
}
