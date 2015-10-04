package com.edreams.main.dao;

import org.codehaus.jackson.map.ObjectMapper;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

public class  ConsumerRestService<T>{

	
	private String url;
	private Class<T> clazz;
	

	public ConsumerRestService() {
		super();
	}


	public ConsumerRestService(String url, Class<T> clazz) {
		super();
		this.url = url;
		this.clazz = clazz;
	}


	public T consumeServiceToJson() throws Exception {

		ClientResponse response = Client.create().resource(url).accept("application/json").get(ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new Exception("Failed : HTTP error code : " + response.getStatus());
		}

		String output = response.getEntity(String.class);
		
		return new ObjectMapper().readValue(output, clazz);
		
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	
}
