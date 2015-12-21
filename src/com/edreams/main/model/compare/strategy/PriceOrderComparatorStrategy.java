package com.edreams.main.model.compare.strategy;

import java.util.Comparator;

import com.edreams.main.bean.Flight;
import com.edreams.main.config.ConfigurationSpring;
import com.edreams.main.config.CurrenciesProperties;
import com.edreams.main.config.FactoryBeans;
import com.edreams.main.model.TransformParamsUrlCurrencyService;
import com.edreams.main.model.compare.beanComparator.ComparatorPrice;
import com.edreams.main.service.IParameterProcessor;

public class PriceOrderComparatorStrategy implements IComparatorStrategy {
	private IParameterProcessor parameterProcessor;
	private CurrenciesProperties conf = FactoryBeans.getInstance(ConfigurationSpring.class).getBean(CurrenciesProperties.class);
	public static final String PRICE_ORDER = "price";
	
	
	public PriceOrderComparatorStrategy(IParameterProcessor parameterProcessor) {
		super();
		this.parameterProcessor = parameterProcessor;
	
	}
	@Override
	public  Comparator<Flight> getComparator() throws Exception{
		
		TransformParamsUrlCurrencyService.setUrl(conf.getUrl());		
		TransformParamsUrlCurrencyService.setRootName(conf.getRootName());
		TransformParamsUrlCurrencyService.getInstance();
		return new ManagerTyperOrder(parameterProcessor, new ComparatorPrice(parameterProcessor.getFirstParameter("orderBy"))).getComparator();		
	}
	@Override
	public boolean isSelected() {
		return PRICE_ORDER.equals(parameterProcessor.getFirstParameter("sorter"));
	}
	
}
