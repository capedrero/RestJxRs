package com.edreams.main.model.compare;

import com.edreams.main.bean.DragonFlight;
import com.edreams.main.bean.ExchangePriceBean;
import com.edreams.main.bean.Flight;
import com.edreams.main.dao.ConsumerRestService;
import com.edreams.main.model.ExchangeRateInitial;
import com.edreams.main.model.ITransformFlightBean;
import com.edreams.main.model.TransformParamsUrlCurrencyService;

public class CalculatorRealPrice implements ITransformFlightBean {
	private TransformParamsUrlCurrencyService transformParamsUrlCurrencyService;


	@Override
	public void transformDragonFlightToFlight(Flight flight, DragonFlight dragonFlight) throws Exception {
		/*TransformParamsUrlCurrencyService transformParamsUrlCurrencyService = new TransformParamsUrlCurrencyService("http://jarvisai.herokuapp.com/currency?from=");
		consumer.setUrl("http://jarvisai.herokuapp.com/currency?from="+dragonFlight.getCurrency()+"&to=EUR");
		ExchangePriceBean exchangePriceBean = new ExchangePriceBean();
		exchangePriceBean.putRate("EUR",consumer.consumeServiceToJson().getObj().getRate());
		ExchangeRate exchangeRate = consumer.consumeServiceToJson().getObj();*/
///////////////To be continued......
	}

}
