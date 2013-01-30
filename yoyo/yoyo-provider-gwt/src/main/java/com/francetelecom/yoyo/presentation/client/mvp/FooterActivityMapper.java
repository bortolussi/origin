package com.francetelecom.yoyo.presentation.client.mvp;

import com.francetelecom.yoyo.presentation.client.ClientFactory;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.impl.FooterPresenterImpl;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

/**
 * FooterActivityMapper maps each Place to its corresponding Activity.
 * 
 */
public class FooterActivityMapper implements ActivityMapper {

	private final ClientFactory clientFactory;

	public FooterActivityMapper(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}

	public Activity getActivity(Place place) {
		return new FooterPresenterImpl(clientFactory.getFooterView());
	}
}
