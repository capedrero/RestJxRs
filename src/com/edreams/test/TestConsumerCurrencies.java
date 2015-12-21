package com.edreams.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.mockito.Mockito;

import com.edreams.main.bean.CURRENCIES;
import com.edreams.main.bean.Flight;
import com.edreams.main.config.ConfigurationSpring;
import com.edreams.main.config.CurrenciesProperties;
import com.edreams.main.config.DragonFlightProperties;
import com.edreams.main.config.FactoryBeans;
import com.edreams.main.model.TransformParamsUrlCurrencyService;
import com.edreams.main.model.compare.BuilderComparator;
import com.edreams.main.model.compare.IBuilderComparator;
import com.edreams.main.model.compare.strategy.IComparatorStrategy;
import com.edreams.main.model.compare.strategy.PriceOrderComparatorStrategy;
import com.edreams.main.model.compare.strategy.TimeDifferenceComparatorStrategy;
import com.edreams.main.service.ParameterProcessor;
import com.fasterxml.jackson.databind.ObjectMapper;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestConsumerCurrencies {
	private CurrenciesProperties conf = FactoryBeans.getInstance(ConfigurationSpring.class).getBean(CurrenciesProperties.class);
	@Test
	public void testPriceOrder() {
		try {

			String input = "{\"currency\":\"EUR\",\"dateArrival\":\"3297-09-10T23:50:00+02:00\",\"dateDeparture\":\"3370-09-14T07:26:00+02:00\",\"destination\":\"Tolos\",\"id\":\"1\",\"origin\":\"White Harbor\",\"price\":\"2250.36\"}";

			Flight flight1= new ObjectMapper().readValue(input, Flight.class);
			input = "{\"currency\":\"USD\",\"dateArrival\":\"3297-09-10T23:50:00+02:00\",\"dateDeparture\":\"3370-09-14T07:26:00+02:00\",\"destination\":\"Tolos\",\"id\":\"2\",\"origin\":\"White Harbor\",\"price\":\"2500.36\"}";
			Flight flight2= new ObjectMapper().readValue(input, Flight.class);
			List<Flight> lFligths = new ArrayList<>();
			lFligths.add(flight1);
			lFligths.add(flight2);
			//System.out.println("sin orden");
			Assert.assertNotNull(lFligths);
			Assert.assertEquals(lFligths.get(0).getId(), Integer.valueOf(1));
			Assert.assertEquals(lFligths.get(1).getId(), Integer.valueOf(2));			
			
			
			ParameterProcessor parameterProcessor = Mockito.mock(ParameterProcessor.class);
			 Mockito.when(parameterProcessor.getFirstParameter("sorter")).thenReturn("price");
			 Mockito.when(parameterProcessor.getFirstParameter("orderBy")).thenReturn("EUR");		
			 Mockito.when(parameterProcessor.getFirstParameter("typeSorter")).thenReturn("desc");
			
			 IBuilderComparator builderComparator = new BuilderComparator(parameterProcessor,
					  new IComparatorStrategy[] { new PriceOrderComparatorStrategy(parameterProcessor),
							  					  new TimeDifferenceComparatorStrategy(parameterProcessor) });
			Collections.sort(lFligths, builderComparator.getComparator());
			//System.out.println("con orden descendente");
			
			Assert.assertEquals(lFligths.get(0).getId(), Integer.valueOf(2));
			Assert.assertEquals(lFligths.get(1).getId(), Integer.valueOf(1));
			

		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail(e.getMessage());

		}	
	}
	@Test
	public void testConcumerCurrencies(){
		try{		
		TransformParamsUrlCurrencyService.setUrl(conf.getUrl());
		TransformParamsUrlCurrencyService.setRootName(conf.getRootName());
		TransformParamsUrlCurrencyService.getInstance();
		Map<String, Double> map = TransformParamsUrlCurrencyService.getExchangePriceBean().getOriginMap(CURRENCIES.GBP);
		System.out.println(CURRENCIES.USD);
		Assert.assertNotNull(map);
		Assert.assertNotEquals(map.size(), 0);
		/*for (Entry<String, Double> item : map.entrySet()) {
			System.out.println(item.getKey()+"=>"+item.getValue());
			
		}*/
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
		
	}
	
}
