package com.francetelecom.yoyo.presentation.client.mvp;

import com.francetelecom.yoyo.presentation.client.mvp.place.HomePlace;
import com.francetelecom.yoyo.presentation.client.mvp.place.MarketAddPlace;
import com.francetelecom.yoyo.presentation.client.mvp.place.MarketEditPlace;
import com.francetelecom.yoyo.presentation.client.mvp.place.MarketListPlace;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

/**
 * Declares all the Places available in your app.
 */
@WithTokenizers({ HomePlace.Tokenizer.class, MarketListPlace.Tokenizer.class,
		MarketAddPlace.Tokenizer.class, MarketEditPlace.Tokenizer.class })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {

}
