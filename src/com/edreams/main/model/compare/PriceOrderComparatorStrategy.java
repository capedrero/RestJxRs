package com.edreams.main.model.compare;

import java.util.Comparator;

import com.edreams.main.bean.Flight;
import com.edreams.main.model.TransformParamsUrlCurrencyService;
import com.edreams.main.service.IParameterProcessor;

public class PriceOrderComparatorStrategy implements IComparatorStrategy {
	private IParameterProcessor parameterProcessor;
	public static final String PRICE_ORDER = "price";
	
	
	public PriceOrderComparatorStrategy(IParameterProcessor parameterProcessor) {
		super();
		this.parameterProcessor = parameterProcessor;
	
	}
	@Override
	public  Comparator<Flight> getComparator() throws Exception{
		TransformParamsUrlCurrencyService.setUrl("http://jarvisai.herokuapp.com/currency?from=");		
		TransformParamsUrlCurrencyService.getInstance();
		return new ManagerTyperOrder(parameterProcessor).getComparator();		
	}
	@Override
	public boolean isSelected() {
		return PRICE_ORDER.equals(parameterProcessor.getFirstParameter("sorter"));
	}
	
}
