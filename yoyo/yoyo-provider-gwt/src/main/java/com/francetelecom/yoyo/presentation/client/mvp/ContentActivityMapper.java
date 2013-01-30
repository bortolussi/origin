package com.francetelecom.yoyo.presentation.client.mvp;

import com.francetelecom.yoyo.presentation.client.ClientFactory;
import com.francetelecom.yoyo.presentation.client.mvp.place.HomePlace;
import com.francetelecom.yoyo.presentation.client.mvp.place.MarketAddPlace;
import com.francetelecom.yoyo.presentation.client.mvp.place.MarketEditPlace;
import com.francetelecom.yoyo.presentation.client.mvp.place.MarketListPlace;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.impl.HomePresenterImpl;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.impl.MarketAddPresenterImpl;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.impl.MarketEditPresenterImpl;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.impl.MarketListPresenterImpl;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;

/**
 * ContentActivityMapper maps each Place to its corresponding Activity.
 * 
 */
public class ContentActivityMapper implements ActivityMapper {

	private final ClientFactory clientFactory;

	public ContentActivityMapper(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}

	public Activity getActivity(Place place) {
		GWT.log("place :" + place);
		if (place instanceof HomePlace)
			return new HomePresenterImpl(clientFactory.getHomeView());
		if (place instanceof MarketListPlace)
			return new MarketListPresenterImpl(clientFactory.getMarketListView(),
					clientFactory.getManageMarketRPCService(),
					clientFactory.getPlaceController());
		if (place instanceof MarketAddPlace)
			return new MarketAddPresenterImpl(clientFactory.getMarketEditView(),
					clientFactory.getManageMarketRPCService(),
					clientFactory.getPlaceController());
		if (place instanceof MarketEditPlace)
			return new MarketEditPresenterImpl(clientFactory.getMarketEditView(),
					clientFactory.getManageMarketRPCService(),
					clientFactory.getPlaceController(),
					((MarketEditPlace) place).getMarketId());
		return null;
	}
}
