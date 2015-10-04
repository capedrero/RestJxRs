package com.edreams.main.dao.json;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.edreams.main.bean.Flight;
import com.edreams.main.model.ITransformFlightBean;


public class JsonFlightManager {
	private File file;
	
	public JsonFlightManager(File file) {
		super();
		this.file = file;
	}
	public Map<Integer, Flight> readJsonJackson() throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		List<Flight> myObjects = mapper.readValue(new JsonFactory().createJsonParser(file), new TypeReference<List<Flight>>(){});
		Map<Integer, Flight> map = new HashMap<>();
		int i = 1;
		for (Flight dragonFlight : myObjects) {
			map.put(i++, dragonFlight);
		}
		return map;
	}
	public void writeJsonJackson(Collection<Flight> list) throws Exception{		
		ObjectMapper myObjectMapper = new ObjectMapper();
		myObjectMapper.setDateFormat(ITransformFlightBean.SIMPLE_DATE_FORMAT);
		myObjectMapper.writeValue(file, list);	
		
	}
}
