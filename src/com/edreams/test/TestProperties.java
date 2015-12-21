package com.edreams.test;

import org.junit.Test;

import com.edreams.main.config.ConfigurationSpring;
import com.edreams.main.config.CurrenciesProperties;
import com.edreams.main.config.DragonFlightProperties;
import com.edreams.main.config.FactoryBeans;


public class TestProperties {
	
@Test
public void test(){
	System.out.println(FactoryBeans.getInstance(ConfigurationSpring.class).getBean(DragonFlightProperties.class).toString());
	System.out.println(FactoryBeans.getInstance(ConfigurationSpring.class).getBean(CurrenciesProperties.class).toString());
	
}
}
