package com.francetelecom.yoyo.presentation.client.mvp.view.impl;

import com.francetelecom.yoyo.presentation.client.GwtApplication;
import com.francetelecom.yoyo.presentation.client.mvp.view.FooterView;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

/**
 * Basic Desktop {@link FooterView} implementation.
 */
public class FooterViewImpl extends Composite implements FooterView {

	private final HTML copyright;
	private final HTML version;

	public FooterViewImpl() {

		// copyright label settings
		copyright = new HTML(GwtApplication.constantes.footer_copyright());
		copyright.setStyleName("copy");

		// version label settings
		version = new HTML(GwtApplication.constantes.footer_version());
		version.setStylePrimaryName("version");

		initWidget(getDisplay());

	}

	private Widget getDisplay() {

		// main widget is footer panel

		// footer panel configuration
		FlowPanel footer = new FlowPanel();
		footer.getElement().setId("footer");
		footer.add(copyright);
		footer.add(version);

		return footer;
	}

}
