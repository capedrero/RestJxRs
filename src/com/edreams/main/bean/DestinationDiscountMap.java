package com.edreams.main.bean;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class DestinationDiscountMap {
private Map<String, BigDecimal> map;
private static final BigDecimal BIGDECIMAL_100 = new BigDecimal(100);


public DestinationDiscountMap() {
	super();
	map = new HashMap<>();
}


public void putDiscount(final String city, Integer rateDiscount){
	map.put(city, new BigDecimal(rateDiscount).divide( BIGDECIMAL_100 ,2, RoundingMode.HALF_UP));
}
public BigDecimal getDiscount(final String city){
	return map.get(city);
}


public Map<String, BigDecimal> getMap() {
	return map;
}

}
