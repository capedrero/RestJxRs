package com.edreams.main.service;

import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

public interface IParameterProcessor {

	void setContext(UriInfo context);
	MultivaluedMap<String, String> getMap();
	String getFirstParameter(String key);

}
