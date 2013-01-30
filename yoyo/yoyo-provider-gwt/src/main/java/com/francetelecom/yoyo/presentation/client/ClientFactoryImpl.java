package com.francetelecom.yoyo.presentation.client;

import com.francetelecom.yoyo.presentation.client.mvp.view.EditView;
import com.francetelecom.yoyo.presentation.client.mvp.view.FooterView;
import com.francetelecom.yoyo.presentation.client.mvp.view.HeaderView;
import com.francetelecom.yoyo.presentation.client.mvp.view.HomeASideBarView;
import com.francetelecom.yoyo.presentation.client.mvp.view.HomeView;
import com.francetelecom.yoyo.presentation.client.mvp.view.ListView;
import com.francetelecom.yoyo.presentation.client.mvp.view.MarketASideBarView;
import com.francetelecom.yoyo.presentation.client.mvp.view.NavigationView;
import com.francetelecom.yoyo.presentation.client.mvp.view.impl.FooterViewImpl;
import com.francetelecom.yoyo.presentation.client.mvp.view.impl.HeaderViewImpl;
import com.francetelecom.yoyo.presentation.client.mvp.view.impl.HomeASideBarViewImpl;
import com.francetelecom.yoyo.presentation.client.mvp.view.impl.HomeViewImpl;
import com.francetelecom.yoyo.presentation.client.mvp.view.impl.MarketASideViewImpl;
import com.francetelecom.yoyo.presentation.client.mvp.view.impl.MarketEditViewImpl;
import com.francetelecom.yoyo.presentation.client.mvp.view.impl.MarketListViewImpl;
import com.francetelecom.yoyo.presentation.client.mvp.view.impl.NavigationViewImpl;
import com.francetelecom.yoyo.presentation.client.rpc.ManageMarketService;
import com.francetelecom.yoyo.presentation.client.rpc.ManageMarketServiceAsync;
import com.francetelecom.yoyo.presentation.client.ui.SiteUI;
import com.francetelecom.yoyo.model.MarketBean;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;

/**
 * Implementation of ClientFactory
 * 
 */
public class ClientFactoryImpl implements ClientFactory {

	private static final EventBus eventBus = new SimpleEventBus();
	private static final PlaceController placeController = new PlaceController(
			eventBus);
	private static final HeaderView HEADER_VIEW = new HeaderViewImpl();
	private static final FooterView FOOTER_VIEW = new FooterViewImpl();
	private static final HomeView HOME_VIEW = new HomeViewImpl();
	private static final HomeASideBarView HOME_ASIDEBAR_VIEW = new HomeASideBarViewImpl();
	private static final ListView<MarketBean> MARKETLIST_VIEW = new MarketListViewImpl();
	private static final NavigationView NAVIGATION_VIEW = new NavigationViewImpl();
	private static final MarketASideBarView MARKET_ASIDEBAR_VIEW = new MarketASideViewImpl();
	private static final EditView<MarketBean> MARKET_EDIT_VIEW = new MarketEditViewImpl();
	private static final SiteUI SITE_UI = new SiteUI();
	private final ManageMarketServiceAsync MANAGE_MARKET_RPC_SERVICE = GWT
			.create(ManageMarketService.class);

	public EventBus getEventBus() {
		return eventBus;
	}

	public HeaderView getHeaderView() {
		return HEADER_VIEW;
	}

	public PlaceController getPlaceController() {
		return placeController;
	}

	public FooterView getFooterView() {
		return FOOTER_VIEW;
	}

	public HomeView getHomeView() {
		return HOME_VIEW;
	}

	public NavigationView getNavigationView() {
		return NAVIGATION_VIEW;
	}

	public ListView<MarketBean> getMarketListView() {
		return MARKETLIST_VIEW;
	}

	public ManageMarketServiceAsync getManageMarketRPCService() {
		return MANAGE_MARKET_RPC_SERVICE;
	}

	public EditView<MarketBean> getMarketEditView() {
		return MARKET_EDIT_VIEW;
	}

	public SiteUI getSiteUI() {
		return SITE_UI;
	}

	public HomeASideBarView getHomeASideBarView() {
		return HOME_ASIDEBAR_VIEW;
	}

	public MarketASideBarView getMarketASideBarView() {
		return MARKET_ASIDEBAR_VIEW;
	}

}
