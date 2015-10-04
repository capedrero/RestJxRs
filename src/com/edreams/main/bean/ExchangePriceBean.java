package com.edreams.main.bean;

import java.util.HashMap;
import java.util.Map;

public class ExchangePriceBean {
private Map<String, Map<String,Double>> mapRates;

public ExchangePriceBean() {
	super();
	mapRates = new HashMap<>();
}

public void putRate(String origin, String dest, Double rate){
	mapRates.get(origin).put(dest, rate);
}
public void inizialiceOriginMap(String origin){
	mapRates.put(origin, new HashMap<String, Double>());
}
public Map<String,Double> getOriginMap(String origin){
	return mapRates.get(origin);
}
public Double getRate(String origin, String dest){
	return mapRates.get(origin).get(dest);
}

}
