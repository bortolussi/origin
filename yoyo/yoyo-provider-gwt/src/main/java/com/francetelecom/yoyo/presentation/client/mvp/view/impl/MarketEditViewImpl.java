package com.francetelecom.yoyo.presentation.client.mvp.view.impl;

import com.francetelecom.yoyo.presentation.client.GwtApplication;
import com.francetelecom.yoyo.presentation.client.mvp.presenter.EditPresenter;
import com.francetelecom.yoyo.presentation.client.mvp.view.EditView;
import com.francetelecom.yoyo.presentation.client.ui.SimpleHasFeedback;
import com.francetelecom.yoyo.model.MarketBean;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.orange.gwt.clara.client.OrangeHelper;
import com.orange.gwt.clara.client.ui.TextAreaFormEntry;
import com.orange.gwt.clara.client.ui.TextFormEntry;
import com.orange.gwt.clara.client.ui.UnNumberedList;
import com.orange.gwt.clara.client.util.Form;
import com.orange.gwt.clara.client.util.FormEntry;
import com.orange.gwt.clara.client.validators.FormEntryValidator;

/**
 * Basic Desktop {@link MarketEditViewImpl} implementation.
 */
public class MarketEditViewImpl extends Form implements EditView<MarketBean> {

	private Integer marketId;
	private final HTML editTitle;
	private final HTML createTitle;
	private final HTML mainTitle;
	private final Button doCancel;
	private final Button doSave;
	private final TextFormEntry marketName;
	private final TextAreaFormEntry marketDescription;
	private final SimpleHasFeedback feedback;
	private EditPresenter<MarketBean> presenter;

	public MarketEditViewImpl() {

		// holds error, warn message
		feedback = new SimpleHasFeedback();

		// cancel button settings
		doCancel = OrangeHelper
				.createOButtonSpecialisedProcessClose(GwtApplication.constantes
						.button_cancel());
		doCancel.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				if (presenter != null)
					presenter.onCancelClicked();
			}
		});

		// save button settings
		doSave = OrangeHelper
				.createOButtonActionLarge(GwtApplication.constantes.button_ok());
		doSave.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				if (!validateMandatoryFields()) {
					nameIsRequired();
				} else {
					if (presenter != null) {
						MarketBean marketBean = new MarketBean(marketId,
								marketName.getValue(), marketDescription
										.getValue());
						presenter.onSaveClicked(marketBean);
					}
				}

			}
		});

		// market name form entry settings
		marketName = new TextFormEntry(GwtApplication.constantes.field_name(),
				"name", true, this);
		marketName.setStylePrimaryName("form-entry");

		// adds an additional validator
		marketName.setValidator(new FormEntryValidator<String>() {

			@Override
			public boolean validate(FormEntry<String> entry) {
				return entry.getValue().length() >= 5;
			}

			@Override
			public String getMessage() {
				// FIXME get and display this message in UI
				return "";
			}
		});

		// enables field validation
		this.addEntry(marketName);

		// market description form entry settings
		marketDescription = new TextAreaFormEntry(
				GwtApplication.constantes.field_description(), "description",
				false, this);

		marketDescription.setStylePrimaryName("form-entry");

		// displayed when mode equals edit
		editTitle = new HTML("<h4>"
				+ GwtApplication.constantes.updateMarketPage_title() + "</h4>");
		// displayed when mode equals create
		createTitle = new HTML("<h4>"
				+ GwtApplication.constantes.createMarketPage_title() + "</h4>");
		// main title
		mainTitle = (new HTML("<h2>"
				+ GwtApplication.constantes.marketPage_title() + "</h2>"));

		initWidget(getDisplay());

	}

	private Widget getDisplay() {

		FlowPanel detail = new FlowPanel();
		detail.getElement().setId("detail");

		FlowPanel input = new FlowPanel();
		input.add(marketName);
		input.add(marketDescription);

		UnNumberedList actionPanel = new UnNumberedList();
		actionPanel.setStylePrimaryName("form-button");
		UnNumberedList.ListItem doSaveItem = actionPanel.new ListItem();
		doSaveItem.add(doSave);
		UnNumberedList.ListItem doCancelItem = actionPanel.new ListItem();
		doCancelItem.add(doCancel);

		actionPanel.add(doSaveItem);
		actionPanel.add(doCancelItem);

		detail.add(mainTitle);
		detail.add(editTitle);
		detail.add(createTitle);
		detail.add(feedback);
		detail.add(input);
		detail.add(actionPanel);

		return detail;
	}

	public void setPresenter(EditPresenter<MarketBean> presenter) {
		this.presenter = presenter;
	}

	public void setCreating(boolean creating) {
		if (creating) {
			editTitle.setVisible(false);
			createTitle.setVisible(true);
		} else {
			editTitle.setVisible(true);
			createTitle.setVisible(false);
		}
	}

	public void reset() {
		marketId = null;
		marketName.setValue("");
		marketDescription.setValue("");
		feedback.clear();
	}

	public void setData(MarketBean item) {
		marketId = (item != null) ? item.getId() : null;
		marketName.setValue((item != null) ? item.getName() : "");
		marketDescription.setValue((item != null) ? item.getDescription() : "");
	}

	public MarketBean getData() {
		return ((noData()) ? null : new MarketBean(marketId,
				marketName.getValue(), marketDescription.getValue()));
	}

	public boolean noData() {
		return (marketId == null && marketName.getValue().equals("") && marketDescription
				.getValue().equals(""));
	}

	public void error() {
		feedback.error(GwtApplication.constantes.error_internal());
	}

	public void optimisticLockError() {
		feedback.error(GwtApplication.constantes.error_optimisticlock());
	}

	public void nameIsRequired() {
		feedback.error(GwtApplication.constantes.name_Required());
	}

	public void duplicateError() {
		feedback.error(GwtApplication.messages.warning_marketAlreadyExists(""));
	}

	@Override
	public void deletionError() {
		feedback.error(GwtApplication.constantes.error_deletion());
	}

}
