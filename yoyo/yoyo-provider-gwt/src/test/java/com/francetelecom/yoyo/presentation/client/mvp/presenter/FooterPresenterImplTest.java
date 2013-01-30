package com.francetelecom.yoyo.presentation.client.mvp.presenter;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.francetelecom.yoyo.presentation.client.mvp.presenter.impl.FooterPresenterImpl;
import com.francetelecom.yoyo.presentation.client.mvp.view.FooterView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

@RunWith(MockitoJUnitRunner.class)
public class FooterPresenterImplTest {

	@Mock
	private FooterView view;

	@Mock
	private AcceptsOneWidget parent;

	private FooterPresenterImpl presenter;

	@Before
	public void setUp() {
		presenter = new FooterPresenterImpl(view);
	}

	@Test
	public void testStartActivity() {
		// run operation to be tested
		presenter.start(parent, mock(EventBus.class));
		// ensure operation has been called with required args
		verify(parent).setWidget(eq(view));
	}

}
