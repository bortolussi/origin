package com.francetelecom.yoyo.presentation.server;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.francetelecom.yoyo.presentation.client.rpc.ManageMarketService;
import com.francetelecom.clara.security.MissingUserPropertyException;
import com.francetelecom.clara.security.SecurityManager;
import com.francetelecom.clara.security.User;
import com.francetelecom.yoyo.application.ManageMarket;
import com.francetelecom.yoyo.model.MarketBean;
import com.francetelecom.yoyo.technicalservice.exception.InvalidMarketException;
import com.francetelecom.yoyo.technicalservice.exception.NotFoundException;
import com.francetelecom.yoyo.technicalservice.exception.TechnicalException;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@SuppressWarnings("serial")
@RemoteServiceRelativePath("manageMarket")
public class ManageMarketDelegate extends
		SpringBeanInjectionRemoteServiceServlet implements ManageMarketService {

	private static final Logger log = LoggerFactory.getLogger(ManageMarketDelegate.class.getName());

	@Autowired
	ManageMarket manageMarketApplication;

	public MarketBean consultMarket(int idMarket)
			throws InvalidMarketException, NotFoundException {
		return manageMarketApplication.consultMarket(idMarket);
	}

	public Integer createMarket(MarketBean market) throws InvalidMarketException,
			TechnicalException {
		return manageMarketApplication.createMarket(market);

	}

	public void deleteMarket(int idMarket) throws InvalidMarketException,
			TechnicalException {
		manageMarketApplication.deleteMarket(idMarket);
	}

	public Map<Integer, MarketBean> findAllMarkets() throws NotFoundException,
			TechnicalException {
		return manageMarketApplication.findAllMarkets();
	}

	public List<MarketBean> findMarketByName(String name)
			throws NotFoundException, TechnicalException {
		return manageMarketApplication.findMarketByName(name);
	}

	public void modifyMarket(MarketBean market) throws InvalidMarketException, NotFoundException,
			TechnicalException {
		manageMarketApplication.modifyMarket(market);
	}

	public String getUserLogin() {

		// Get and store the user provided by gassi/security framework in
		// servletContext
		User user;
		try {
			SecurityManager securityManager = SecurityManager
					.getContextInstance(getServletContext());

			user = securityManager.getUser(getThreadLocalRequest());

			if (log.isDebugEnabled()) {
				log.info("User found : " + user);
			}
		} catch (ServletException e) {
			if (log.isInfoEnabled()) {
				log.info("User NOT found, no SecurityManager");
			}
			user = new User("xxxx0000", Arrays.asList(""), null,
					new HashMap<String, String>());
		} catch (MissingUserPropertyException e) {
			if (log.isInfoEnabled()) {
				log.info("User NOT found, no User property");
			}
			user = new User("xxxx0000", Arrays.asList(""), null,
					new HashMap<String, String>());
		}
		return user.getId();
	}
}
