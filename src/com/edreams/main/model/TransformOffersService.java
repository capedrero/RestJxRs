package com.edreams.main.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.edreams.main.bean.DestinationDiscountBean;
import com.edreams.main.bean.DestinationDiscountMap;
import com.edreams.main.dao.ConsumerRestService;

public class TransformOffersService {
	private static TransformOffersService mySelf;
	private static String rootName;
	private static String url;
	private static DestinationDiscountMap destinationDiscountMap;


	
	public static TransformOffersService getInstance() throws Exception{
		if(mySelf==null){
			mySelf = new TransformOffersService();			
			destinationDiscountMap = new DestinationDiscountMap();
			mySelf.process();
		}
		return mySelf;
	}

	
public void process() throws Exception{
	ConsumerRestService consumer = new ConsumerRestService();
	//consumer.setUrl("http://odigeo-testbackend.herokuapp.com/discount");
	consumer.setUrl(TransformOffersService.url);	
	if(TransformOffersService.rootName!=null){
		consumer.setRootName(rootName);
	}
	List<DestinationDiscountBean> beans = consumer.consumeServiceToJsonList(DestinationDiscountBean.class);		
	
	for (DestinationDiscountBean bean :  beans) {
		destinationDiscountMap.putDiscount(bean.getCity(), bean.getRateDiscount());
	}

}


public BigDecimal getDiscount(final String city) {
	return destinationDiscountMap.getDiscount(city);
}


public Map<String, BigDecimal> getDestinationDiscountMap() {
	return destinationDiscountMap.getMap();
}


public static void setUrl(String url) {
	TransformOffersService.url = url;
}


public static void setRootName(String rootName) {
	TransformOffersService.rootName = rootName;
}

}
