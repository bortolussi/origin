package com.francetelecom.yoyo.business.transform;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.francetelecom.yoyo.model.MarketBean;
import com.francetelecom.yoyo.model.persistent.Market;

/**
 * Transform persistent objects from/to data transfer objects
 * 
 * @author Clara
 */
public class MarketTransform {

	/**
	 * @param marketPersist
	 *            a persistent market
	 * @return a market bean
	 */
	static final public MarketBean persistant2Bean(Market marketPersist) {
		MarketBean marketBean = new MarketBean(marketPersist.getId(),
				marketPersist.getName(), marketPersist.getDescription());
		// propagate version through all layers
		marketBean.setVersion(marketPersist.getVersion());
		//propagate lastModified
		marketBean.setLastModified(marketPersist.getLastModified());
		return marketBean;
	}

	/**
	 * @param marketPersistList
	 *            a persistent market List
	 * @return a market bean List
	 */
	static final public List<MarketBean> persistant2BeanCollection(
			List<Market> marketPersistList) {
		List<MarketBean> marketBeanList = null;
		if (marketPersistList != null) {
			marketBeanList = new ArrayList<MarketBean>();

			Iterator<Market> it = marketPersistList.iterator();
			Market marketPersist;
			MarketBean marketBean;

			while (it.hasNext()) {
				marketPersist = it.next();
				marketBean = persistant2Bean(marketPersist);
				marketBeanList.add(marketBean);
			}
		}
		return marketBeanList;
	}

	/**
	 * @param marketPersistList
	 *            a persistent market Collection
	 * @return a market bean Map (id map=idMarket, value = Market bean)
	 */
	static final public Map<Integer, MarketBean> persistant2BeanMap(
			Collection<Market> marketPersistList) {
		Map<Integer, MarketBean> marketBeanMap = null;
		if (marketPersistList != null) {
			marketBeanMap = new HashMap<Integer, MarketBean>(marketPersistList
					.size());
			MarketBean marketBean;
			for (Market marketPersist : marketPersistList) {
				marketBean = persistant2Bean(marketPersist);
				marketBeanMap.put(marketBean.getId(), marketBean);
			}
		}
		return marketBeanMap;
	}

	/**
	 * @param marketBean
	 *            a market bean
	 * @return a persistent market
	 */
	public static Market bean2Persistant(MarketBean marketBean) {

		Market marketPersist = new Market(marketBean.getName(), marketBean
				.getDescription());

		if (marketBean.getId() != null ) {
			marketPersist.setId(Integer.valueOf(marketBean.getId()));
		}

		
		// Do not copy version field (the JPA specification forbid 
		// any version update) but check it on modify() methods

		return marketPersist;
	}

	/**
	 * @param marketBeanCollection
	 *            a market bean List
	 * @return a persistent market collection
	 */
	public static List<Market> bean2PersistantCollection(
			Collection<MarketBean> marketBeanCollection) {

		List<Market> marketPersistList = null;
		Market marketPersist;
		if (marketBeanCollection != null) {
			marketPersistList = new ArrayList<Market>(marketBeanCollection
					.size());
			for (MarketBean marketBean : marketBeanCollection) {
				marketPersist = bean2Persistant(marketBean);
				marketPersistList.add(marketPersist);
			}
		}
		return marketPersistList;
	}
}
