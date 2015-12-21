package com.edreams.main.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.edreams.main.cfg" })
@EnableConfigurationProperties({DragonFlightProperties.class,CurrenciesProperties.class} )
public class ConfigurationSpring {

	// Segunda configuración ligada al bean
	@Autowired
	private DragonFlightProperties dfProp;
	@Autowired
	private CurrenciesProperties ccyProp;



}
