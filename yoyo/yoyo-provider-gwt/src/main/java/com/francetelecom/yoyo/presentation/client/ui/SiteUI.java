package com.francetelecom.yoyo.presentation.client.ui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * Site UI widget. It is split into several widget containers: <li>header :
 * holds the header widgets</li> <li>menu : holds the menu widgets</li> <li>
 * sidebar : holds the sidebar widgets</li> <li>content : holds the content
 * widgets</li> <li>footer : holds the footer widgets</li>
 */
public class SiteUI extends Composite {

	/**
	 * holds the header widgets
	 */
	private final SimplePanel header;
	/**
	 * holds the menu widgets
	 */
	private final SimplePanel menu;
	/**
	 * holds the content widgets
	 */
	private final SimplePanel content;
	/**
	 * holds the sidebar widgets
	 */
	private final SimplePanel sidebar;
	/**
	 * holds the footer widgets
	 */
	private final SimplePanel footer;

	public SiteUI() {

		header = new SimplePanel();
		menu = new SimplePanel();
		content = new SimplePanel();
		sidebar = new SimplePanel();
		footer = new SimplePanel();

		FlowPanel center = new FlowPanel();
		center.add(content);

		HorizontalPanel main = new HorizontalPanel();
		main.getElement().setId("main");
		main.add(sidebar);
		main.add(center);

		FlowPanel site = new FlowPanel();
		site.setStylePrimaryName("site");
		site.add(header);
		site.add(menu);
		site.add(main);
		site.add(footer);

		initWidget(site);
	}

	/**
	 * @return the panel to hold the side bar
	 */
	public SimplePanel getSidePanel() {
		return sidebar;
	}

	/**
	 * @return the panel to hold the main
	 */
	public SimplePanel getContentPanel() {
		return content;
	}

	/**
	 * @return the panel to hold the header
	 */
	public SimplePanel getHeaderPanel() {
		return header;
	}

	/**
	 * @return the panel to hold the footer
	 */
	public SimplePanel getFooterPanel() {
		return footer;
	}

	/**
	 * @return the panel to hold the menu
	 */
	public SimplePanel getMenuPanel() {
		return menu;
	}

}
