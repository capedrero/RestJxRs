package com.edreams.main.dao;


import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

public class  ConsumerRestService implements IConsumerRestService{

	
	private String url;	
	private String rootName;
	

	public ConsumerRestService() {
		super();
	}


	public ConsumerRestService(String url) {
		super();
		this.url = url;	
	}

	@Override
	public <T> T consumeServiceToJson(Class<T> classToTransform) throws Exception {

		String output = preClientProcess();
		

		return new CommandObjectReader().processRoot(rootName, classToTransform).readValue(output);		
		
	}
	@Override
	public <T, K> List<T> consumeServiceToJson(Class<K> rawType, Class<T> classToTransform) throws Exception {

		String output = preClientProcess();
			
		return new CommandObjectReaderList().processRoot(rootName, rawType, classToTransform).readValue(output);		
		
	}
	
	


	private String preClientProcess() throws Exception {
		ClientResponse response = Client.create().resource(url).accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new Exception("Failed : HTTP error code : " + response.getStatus());
		}

		String output = response.getEntity(String.class);
		return output;
	}


	@Override
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public void setRootName(String rootName) {
		this.rootName = rootName;
	}
	
	
	
}
