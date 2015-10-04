package com.edreams.main.dao.json;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.edreams.main.bean.Booking;
import com.edreams.main.model.ITransformFlightBean;


public class JsonBookingManager {
	private File file;
	
	public JsonBookingManager(File file) {
		super();
		this.file = file;
	}
	public Map<Integer, Booking> readJsonJackson() throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		List<Booking> myObjects = mapper.readValue(new JsonFactory().createJsonParser(file), new TypeReference<List<Booking>>(){});
		Map<Integer, Booking> map = new HashMap<>();
		int i = 1;
		for (Booking booking : myObjects) {
			map.put(i++, booking);
		}
		return map;
	}
	public void writeJsonJackson(Collection<Booking> list) throws Exception{			
		ObjectMapper myObjectMapper = new ObjectMapper();
		myObjectMapper.setDateFormat(ITransformFlightBean.SIMPLE_DATE_FORMAT);
		myObjectMapper.writeValue(file, list);	
		
	}
}
