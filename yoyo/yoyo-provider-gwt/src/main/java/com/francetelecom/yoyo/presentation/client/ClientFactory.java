package com.francetelecom.yoyo.presentation.client;

import com.francetelecom.yoyo.presentation.client.mvp.view.EditView;
import com.francetelecom.yoyo.presentation.client.mvp.view.FooterView;
import com.francetelecom.yoyo.presentation.client.mvp.view.HeaderView;
import com.francetelecom.yoyo.presentation.client.mvp.view.HomeASideBarView;
import com.francetelecom.yoyo.presentation.client.mvp.view.HomeView;
import com.francetelecom.yoyo.presentation.client.mvp.view.ListView;
import com.francetelecom.yoyo.presentation.client.mvp.view.MarketASideBarView;
import com.francetelecom.yoyo.presentation.client.mvp.view.NavigationView;
import com.francetelecom.yoyo.presentation.client.rpc.ManageMarketServiceAsync;
import com.francetelecom.yoyo.presentation.client.ui.SiteUI;
import com.francetelecom.yoyo.model.MarketBean;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;

/**
 * A ClientFactory is not strictly required in GWT 2.1; however, it is helpful
 * to use a factory or dependency injection framework like GIN to obtain
 * references to objects needed throughout your application like the event bus.
 * Our example uses a ClientFactory to provide an EventBus, GWT PlaceController,
 * and view implementations. Another advantage of using a ClientFactory is that
 * you can use it with GWT deferred binding to use different implementation
 * classes based on user.agent or other properties. For example, you might use a
 * MobileClientFactory to provide different view implementations than the
 * default desktop ClientFactoryImpl. To do this, instantiate your ClientFactory
 * with GWT.create in onModuleLoad()
 * 
 */
public interface ClientFactory {

	public EventBus getEventBus();

	public ManageMarketServiceAsync getManageMarketRPCService();

	public PlaceController getPlaceController();

	public HeaderView getHeaderView();

	public FooterView getFooterView();

	public HomeView getHomeView();

	public HomeASideBarView getHomeASideBarView();

	public NavigationView getNavigationView();

	public ListView<MarketBean> getMarketListView();

	public MarketASideBarView getMarketASideBarView();

	public EditView<MarketBean> getMarketEditView();

	public SiteUI getSiteUI();

}
