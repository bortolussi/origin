package com.francetelecom.yoyo.presentation.client.ui;

import com.francetelecom.yoyo.presentation.client.GwtApplication;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.view.client.HasRows;
import com.google.gwt.view.client.Range;

/**
 * 
 * supports i18n in pager label
 * 
 */
public class MarketListSimplePager extends SimplePager {

	public MarketListSimplePager(TextLocation center, Resources pagerResources,
			boolean b, int i, boolean c) {
		super(center, pagerResources, b, i, c);
	}

	@Override
	protected String createText() {
		// Default text is 1 based.
		NumberFormat formatter = NumberFormat.getFormat("#,###");
		HasRows display = getDisplay();
		Range range = display.getVisibleRange();
		int pageStart = range.getStart() + 1;
		int pageSize = range.getLength();
		int dataSize = display.getRowCount();
		int endIndex = Math.min(dataSize, pageStart + pageSize - 1);
		endIndex = Math.max(pageStart, endIndex);
		// boolean exact = display.isRowCountExact();
		return formatter.format(pageStart) + "-" + formatter.format(endIndex)
				+ (" " + GwtApplication.constantes.marketPage_pager() + " ")
				+ formatter.format(dataSize);
	}
}
