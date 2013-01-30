package com.francetelecom.yoyo.presentation.client.mvp.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * In order to be accessible via a URL, an Activity needs a corresponding Place.
 * A Place extends {@link com.google.gwt.app.place.Place} and must have an
 * associated PlaceTokenizer which knows how to serialize the Place's state to a
 * URL token. By default, the URL consists of the Place's simple class name
 * (like "HelloPlace") followed by a colon (:) and the token returned by the
 * PlaceTokenizer.
 */
public class MarketEditPlace extends Place {

	private final String marketId;

	public MarketEditPlace(String token) {
		super();
		marketId = token;
	}

	public String getMarketId() {
		return marketId;
	}

	public static class Tokenizer implements PlaceTokenizer<MarketEditPlace> {

		public MarketEditPlace getPlace(String token) {
			return new MarketEditPlace(token);
		}

		public String getToken(MarketEditPlace place) {
			return place.getMarketId();
		}

	}

}
