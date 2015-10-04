package com.edreams.main.model;

import com.edreams.main.bean.CURRENCIES;
import com.edreams.main.bean.ExchangePriceBean;
import com.edreams.main.dao.ConsumerRestService;

public class TransformParamsUrlCurrencyService {
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

		ConsumerRestService<ExchangeRateInitial> consumer = new ConsumerRestService<ExchangeRateInitial>();
		consumer.setClazz(ExchangeRateInitial.class);
		exchangePriceBean = new ExchangePriceBean();
		for (String ccyOrigin : CCY) {
			exchangePriceBean.inizialiceOriginMap(ccyOrigin);
			for (String ccyDest : CCY) {
				consumer.setUrl(url+ccyOrigin+"&to="+ccyDest);
				ExchangeRateInitial bean = consumer.consumeServiceToJson();
				exchangePriceBean.putRate(ccyOrigin , ccyDest, bean.getObj().getRate());
			}
		}
	}
	
	public static ExchangePriceBean getExchangePriceBean() {
		return exchangePriceBean;
	}
	public static void setUrl(String url) {
		TransformParamsUrlCurrencyService.url = url;
	}
	
	
		

}
