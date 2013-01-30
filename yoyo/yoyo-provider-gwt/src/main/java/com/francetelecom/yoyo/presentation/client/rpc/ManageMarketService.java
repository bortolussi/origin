package com.francetelecom.yoyo.presentation.client.rpc;

import com.francetelecom.yoyo.application.ManageMarket;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("manageMarket")
public interface ManageMarketService extends ManageMarket, RemoteService {

	/**
	 * @return user login
	 */
	public String getUserLogin();

}
