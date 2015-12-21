package com.edreams.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.edreams.main.bean.DragonFlight;
import com.edreams.main.config.ConfigurationSpring;
import com.edreams.main.config.DragonFlightProperties;
import com.edreams.main.config.FactoryBeans;
import com.edreams.main.dao.ConsumerRestService;
import com.edreams.main.dao.IConsumerRestService;

public class TestConsumeDragonFlight {
	private DragonFlightProperties conf = FactoryBeans.getInstance(ConfigurationSpring.class).getBean(DragonFlightProperties.class);


	@Test
	public void testConsumeDragonFlight() {
		try {
				
			IConsumerRestService consumer = new ConsumerRestService(conf.getUrl());
			consumer.setRootName(conf.getRootName());
			List<DragonFlight> myObjects = consumer.consumeServiceToJson(List.class, DragonFlight.class);	
			Assert.assertNotNull(myObjects);
			Assert.assertNotEquals(0, myObjects.size());
			System.out.println("List Dragon Flight "+myObjects.size());

		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail(e.getMessage());

		}
	}

}
