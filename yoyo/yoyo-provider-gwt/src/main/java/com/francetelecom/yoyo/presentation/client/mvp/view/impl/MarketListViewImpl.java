package com.francetelecom.yoyo.presentation.client.mvp.view.impl;

import java.util.ArrayList;
import java.util.List;

import com.francetelecom.yoyo.presentation.client.GwtApplication;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.ListPresenter;
import com.francetelecom.yoyo.presentation.client.mvp.view.ListView;
import com.francetelecom.yoyo.presentation.client.ui.MarketListSimplePager;
import com.francetelecom.yoyo.presentation.client.ui.SimpleHasFeedback;
import com.francetelecom.yoyo.model.MarketBean;
import com.google.gwt.cell.client.ClickableTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.text.shared.AbstractSafeHtmlRenderer;
import com.google.gwt.text.shared.SafeHtmlRenderer;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.Range;
import com.google.gwt.view.client.RangeChangeEvent;
import com.google.gwt.view.client.RangeChangeEvent.Handler;

/**
 * Basic Desktop {@link ListView} implementation.
 */
public class MarketListViewImpl extends Composite implements
		ListView<MarketBean> {

	private final CellTable<MarketBean> marketTable;
	private final SimplePager pager;
	private final static int PAGE_SIZE = 3;
	private List<MarketBean> markets;
	private SimpleHasFeedback feedback;

	private ListPresenter<MarketBean> presenter;

	public MarketListViewImpl() {

		feedback = new SimpleHasFeedback();
		// Create a CellTable.
		marketTable = new CellTable<MarketBean>();
		marketTable.getElement().setId("marketlist");
		marketTable.setPageSize(PAGE_SIZE);
		marketTable.setRowCount(0, true);

		marketTable.addRangeChangeHandler(new Handler() {

			public void onRangeChange(RangeChangeEvent event) {
				Range range = marketTable.getVisibleRange();
				int start = range.getStart();
				int length = range.getLength();
				List<MarketBean> toSet = new ArrayList<MarketBean>(length);
				for (int i = start; i < start + length && i < markets.size(); i++)
					toSet.add(markets.get(i));
				marketTable.setRowData(start, toSet);

			}
		});

		// Create a Pager to control the table.
		SimplePager.Resources pagerResources = GWT
				.create(SimplePager.Resources.class);
		pager = new MarketListSimplePager(TextLocation.CENTER, pagerResources,
				false, 0, true);
		pager.setDisplay(marketTable);

		// Create id column.
		TextColumn<MarketBean> idColumn = new TextColumn<MarketBean>() {

			@Override
			public String getValue(MarketBean market) {
				return market.getId().toString();
			}

		};

		// renderer for nameColumn
		SafeHtmlRenderer<String> nameColumnRenderer = new AbstractSafeHtmlRenderer<String>() {

			public SafeHtml render(String object) {
				// FIXME voir si il est possible de supprimer ce code HTML
				SafeHtmlBuilder builder = new SafeHtmlBuilder();
				builder.appendHtmlConstant("<a href=\"javascript:;\">");
				builder.appendEscaped(object);
				builder.appendHtmlConstant("</a>");
				return builder.toSafeHtml();
			}

		};

		// Create name column.
		Column<MarketBean, String> nameColumn = new Column<MarketBean, String>(
				new ClickableTextCell(nameColumnRenderer)) {

			@Override
			public String getValue(MarketBean marketBean) {
				return marketBean.getName();
			}
		};

		nameColumn.setFieldUpdater(new FieldUpdater<MarketBean, String>() {
			public void update(int index, MarketBean marketBean, String value) {
				if (presenter != null) {
					presenter.onEditClicked(marketBean);
				}
			}
		}

		);

		// renderer for nameColumn
		SafeHtmlRenderer<String> deleteColumnRenderer = new AbstractSafeHtmlRenderer<String>() {

			public SafeHtml render(String object) {
				SafeHtmlBuilder builder = new SafeHtmlBuilder();
				// FIXME voir si il est possible de supprimer ce code HTML
				builder.appendHtmlConstant("<a href=\"javascript:;\"><img src=\"images/btnDelete.gif\"/></a>");
				return builder.toSafeHtml();
			}

		};

		// delete column.
		Column<MarketBean, String> deleteColumn = new Column<MarketBean, String>(
				new ClickableTextCell(deleteColumnRenderer)) {

			@Override
			public String getValue(MarketBean marketBean) {
				return GwtApplication.constantes.button_delete();
			}
		};

		deleteColumn.setFieldUpdater(new FieldUpdater<MarketBean, String>() {
			public void update(int index, MarketBean marketBean, String value) {
				if (presenter != null) {
					presenter.onDeleteClicked(marketBean);
				}
			}
		}

		);

		// Create description column.
		TextColumn<MarketBean> descriptionColumn = new TextColumn<MarketBean>() {

			@Override
			public String getValue(MarketBean market) {
				return market.getDescription();
			}
		};

		marketTable.addColumn(idColumn,
				GwtApplication.constantes.column_marketId());
		marketTable.addColumn(nameColumn,
				GwtApplication.constantes.column_marketName());
		marketTable.addColumn(descriptionColumn,
				GwtApplication.constantes.column_marketDescription());
		marketTable.addColumn(deleteColumn, "");

		initWidget(getDisplay());
	}

	private Widget getDisplay() {

		// main panel is content panel

		// content panel configuration
		FlowPanel content = new FlowPanel();
		content.getElement().setId("content");
		content.add(new HTML("<h2>"
				+ GwtApplication.constantes.marketPage_title() + "</h2>"));
		content.add(new HTML("<h4>"
				+ GwtApplication.constantes.marketPage_result() + "</h4>"));
		content.add(feedback);
		content.add(marketTable);
		content.add(pager);

		return content;

	}

	public void setData(List<MarketBean> markets) {
		this.markets = markets;
		marketTable.setRowCount(markets.size(), true);
		marketTable.setRowData(0, markets);
		marketTable.setVisible(!this.markets.isEmpty());
		pager.setVisible(!this.markets.isEmpty());
	}

	public void setPresenter(ListPresenter<MarketBean> presenter) {
		this.presenter = presenter;
	}

	public void reset() {
		feedback.clear();
	}

	public void error() {
		feedback.error(GwtApplication.constantes.error_internal());
	}

	public void noData() {
		this.setData(new ArrayList<MarketBean>());
		feedback.info(GwtApplication.messages.list_counter_none());
	}

	public boolean confirmDeletion(MarketBean marketBean) {
		return feedback.confirm(GwtApplication.messages
				.deleteMarketPage_confirm(String.valueOf(marketBean.getId())));

	}

}
