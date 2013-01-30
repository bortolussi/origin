package com.francetelecom.yoyo.presentation.client.mvp;

import com.francetelecom.yoyo.presentation.client.ClientFactory;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.impl.HeaderPresenterImpl;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

/**
 * HeaderActivityMapper maps each Place to its corresponding Activity.
 * 
 */
public class HeaderActivityMapper implements ActivityMapper {

	private final ClientFactory clientFactory;

	public HeaderActivityMapper(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}

	public Activity getActivity(Place place) {
		return new HeaderPresenterImpl(clientFactory.getHeaderView(),
				clientFactory.getManageMarketRPCService());
	}
}
