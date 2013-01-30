package com.francetelecom.yoyo.presentation.client.ui;

public interface HasFeedback {

	public boolean confirm(String msg);

	public void info(String msg);

	public void warning(String msg);

	public void error(String msg);

}
