package com.edreams.main.model.compare;

import java.util.Comparator;

import com.edreams.main.bean.Flight;
import com.edreams.main.model.TransformParamsUrlCurrencyService;

public class ComparatorPrice implements Comparator<Flight> {
	private String ccy;


	public ComparatorPrice(String ccy){
		super();
		this.ccy = ccy;		
	}

	@Override
	public int compare(Flight bean1, Flight bean2) {
		return Double.compare(
				bean1.getPrice()
						* TransformParamsUrlCurrencyService.getExchangePriceBean().getRate(bean1.getCurrency(), ccy),
				bean2.getPrice()
						* TransformParamsUrlCurrencyService.getExchangePriceBean().getRate(bean2.getCurrency(), ccy));
	}

}
