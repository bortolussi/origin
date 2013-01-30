package com.francetelecom.yoyo.presentation.client.rpc;

import java.util.List;
import java.util.Map;

import com.francetelecom.yoyo.model.MarketBean;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Async version
 * 
 */
public interface ManageMarketServiceAsync {

	void consultMarket(int idMarket, AsyncCallback<MarketBean> callback);

	void createMarket(MarketBean market, AsyncCallback<Integer> callback);

	void deleteMarket(int idMarket, AsyncCallback<Void> callback);

	void findAllMarkets(AsyncCallback<Map<Integer, MarketBean>> callback);

	void findMarketByName(String name, AsyncCallback<List<MarketBean>> callback);

	void modifyMarket(MarketBean market, AsyncCallback<Void> callback);

	void getUserLogin(AsyncCallback<String> callback);

}
