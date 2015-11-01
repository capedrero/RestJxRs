package com.edreams.test;

import java.math.BigDecimal;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;

import com.edreams.main.controller.ManagerFlightOffers;
import com.edreams.main.model.TransformOffersService;
import com.edreams.main.offer.IStrategyFlightOffer;
import com.edreams.main.offer.StrategyFlightOffer;

public class TestManagerOffers {

	@Test
public void testManager(){
	ManagerFlightOffers managerOffers = new ManagerFlightOffers();
	try {
		managerOffers.process(new IStrategyFlightOffer[]{new StrategyFlightOffer("http://odigeo-testbackend.herokuapp.com/discount", "results")});
		System.out.println("Descuentos:");
		for (Entry<String, BigDecimal> item : TransformOffersService.getInstance().getDestinationDiscountMap().entrySet()){
			System.out.println(item.getKey()+" "+item.getValue());
		}
	} catch (Exception e) {
		e.printStackTrace();
		Assert.fail(e.getMessage());
		
	}
}

}
