package com.francetelecom.yoyo.presentation.client.ui;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.orange.gwt.clara.client.ui.UnNumberedList;

public class SimpleHasFeedback extends Composite implements HasFeedback {

	protected final UnNumberedList feedback;

	public SimpleHasFeedback() {
		feedback = new UnNumberedList();
		feedback.setStylePrimaryName("feedbackPanel");
		initWidget(feedback);
	}

	public boolean confirm(String msg) {
		return Window.confirm(msg);
	}

	public void info(String msg) {
		addFeedback(msg, "feedbackPanelINFO");
	}

	public void warning(String msg) {
		addFeedback(msg, "feedbackPanelWARNING");
	}

	public void error(String msg) {
		addFeedback(msg, "feedbackPanelERROR");
	}

	private void addFeedback(String msg, String style) {
		UnNumberedList.ListItem item = feedback.new ListItem();
		item.setStylePrimaryName(style);
		item.add(new Label(msg));
		feedback.add(item);
	}

	public void clear() {
		feedback.clear();
	}

}
