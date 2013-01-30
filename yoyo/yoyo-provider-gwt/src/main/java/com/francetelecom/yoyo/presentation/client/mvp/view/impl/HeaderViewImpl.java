package com.francetelecom.yoyo.presentation.client.mvp.view.impl;

import com.francetelecom.yoyo.presentation.client.GwtApplication;
import com.francetelecom.yoyo.presentation.client.mvp.view.HeaderView;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.orange.gwt.clara.client.ui.UnNumberedList;

/**
 * Basic Desktop {@link HeaderView} implementation.
 */
public class HeaderViewImpl extends Composite implements HeaderView {

	private final HTML userLogin;
	private final Anchor doLogout;
	private final Anchor doSwitchEn;
	private final Anchor doSwitchFr;
	private final Anchor doContactUs;
	private final Image logoOrange;
	private static final String LOGOUT_HREF = "gassi/pages/logoff.jsp";
	private static final String CONTACTUS_HREF = "mailto:clara@francetelecom.com";
	private static final String FR_LOCALE_HREF = "?locale=fr";
	private static final String EN_LOCALE_HREF = "?locale=en";

	public HeaderViewImpl() {

		// user login settings
		userLogin = new HTML();
		userLogin.addStyleName("userlogin");

		// logo image settings
		logoOrange = new Image(GwtApplication.images.logoOrange());

		// logout anchor configuration
		doLogout = new Anchor(GwtApplication.constantes.header_logout());
		// TODO voir si il est possible de mettre code suivant ds activity
		// associee
		doLogout.setHref(LOGOUT_HREF);

		// switch to english anchor configuration
		doSwitchEn = new Anchor(GwtApplication.constantes.header_english());
		// TODO voir si il est possible de mettre code suivant ds activity
		// associee
		doSwitchEn.setHref(EN_LOCALE_HREF);
		doSwitchEn.setStylePrimaryName("link");

		// switch to french anchor configuration
		doSwitchFr = new Anchor(GwtApplication.constantes.header_french());
		// TODO voir si il est possible de mettre code suivant ds activity
		// associee
		doSwitchFr.setHref(FR_LOCALE_HREF);
		doSwitchFr.setStylePrimaryName("link");

		// contact us anchor configuration
		doContactUs = new Anchor(GwtApplication.constantes.header_writeus());
		// TODO voir si il est possible de mettre code suivant ds activity
		// associee
		doContactUs.setHref(CONTACTUS_HREF);

		initWidget(getDisplay());

	}

	private Widget getDisplay() {

		// main widget is header panel
		// header panel contains logo panel
		// header panel contains username panel
		// header panel contains signout panel
		// header panel contains menu panel

		// menu panel configuration
		UnNumberedList username = new UnNumberedList();
		username.getElement().setId("username");

		// logo panel configuration
		SimplePanel logo = new SimplePanel();
		logo.getElement().setId("logo");
		logo.setWidget(logoOrange);

		// username panel configuration
		// hello list element
		UnNumberedList.ListItem helloElem = username.new ListItem();
		helloElem.add(new HTML(GwtApplication.constantes.header_hello()));
		// userLogin list element
		UnNumberedList.ListItem userLoginElem = username.new ListItem();
		userLoginElem.add(userLogin);
		//
		username.add(helloElem);
		username.add(userLoginElem);

		// signout panel configuration
		FlowPanel signout = new FlowPanel();
		signout.getElement().setId("signout");
		signout.add(doLogout);

		// menu panel configuration
		UnNumberedList menu = new UnNumberedList();
		menu.getElement().setId("menu");
		// switchEn list element
		UnNumberedList.ListItem switchEnElem = menu.new ListItem();
		switchEnElem.add(doSwitchEn);
		// switchFr list element
		UnNumberedList.ListItem switchFrElem = menu.new ListItem();
		switchFrElem.add(doSwitchFr);
		// contactUs list element
		UnNumberedList.ListItem contactUsElem = menu.new ListItem();
		contactUsElem.add(doContactUs);
		contactUsElem.setStylePrimaryName("first");

		menu.add(contactUsElem);
		menu.add((LocaleInfo.getCurrentLocale().getLocaleName().equals("en")) ? switchFrElem
				: switchEnElem);
		// menu.add(switchEnElem);
		// menu.add(switchFrElem);

		// header panel configuration
		FlowPanel header = new FlowPanel();
		header.getElement().setId("header");
		header.add(logo);
		header.add(username);
		header.add(signout);
		header.add(menu);

		return header;

	}

	public void setUserLogin(String login) {
		this.userLogin.setText(login);
	}

	public void error() {
		Window.alert(GwtApplication.constantes.error_internal());
	}

}