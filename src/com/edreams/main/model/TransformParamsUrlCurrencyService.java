package com.edreams.main.model;

import com.edreams.main.bean.CURRENCIES;
import com.edreams.main.bean.ExchangePriceBean;
import com.edreams.main.dao.ConsumerRestService;
import com.edreams.main.dao.IConsumerRestService;
import com.edreams.main.model.compare.ExchangeRate;

public class TransformParamsUrlCurrencyService {
	private static String rootName;
	private static String url;
	private static ExchangePriceBean exchangePriceBean;
	private static final String[] CCY = {CURRENCIES.EUR,CURRENCIES.USD,CURRENCIES.GBP,CURRENCIES.JPY}; 
	private static TransformParamsUrlCurrencyService myself;
	
	public static TransformParamsUrlCurrencyService getInstance() throws Exception{
		if(myself==null){
			myself = new TransformParamsUrlCurrencyService();
			myself.processCurrencys();
			return myself;
		}
		return myself;
	}
	
	public void processCurrencys() throws Exception{

		IConsumerRestService consumer = new ConsumerRestService();		
		if(rootName!=null){
			consumer.setRootName(rootName);
		}
		exchangePriceBean = new ExchangePriceBean();
		for (String ccyOrigin : CCY) {
			exchangePriceBean.inizialiceOriginMap(ccyOrigin);
			for (String ccyDest : CCY) {
				consumer.setUrl(url+ccyOrigin+"&to="+ccyDest);
				ExchangeRate bean = consumer.consumeServiceToJson(ExchangeRate.class);
				exchangePriceBean.putRate(ccyOrigin , ccyDest, bean.getRate());
			}
		}
	}
	
	public static ExchangePriceBean getExchangePriceBean() {
		return exchangePriceBean;
	}
	public Double getRate(final String ccyOrigin, final String ccyDestin) {
		return exchangePriceBean.getRate(ccyOrigin, ccyDestin);
	}
	public static void setUrl(String url) {
		TransformParamsUrlCurrencyService.url = url;
	}

	public static void setRootName(String rootName) {
		TransformParamsUrlCurrencyService.rootName = rootName;
	}
	
	
	
		

}
