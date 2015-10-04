package com.edreams.main.dao.json;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.edreams.main.bean.User;


public class JsonDragonFlightManager {
	private File file;
	
	public JsonDragonFlightManager(File file) {
		super();
		this.file = file;
	}
	public Map<Integer, User> readJsonUserJackson() throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		List<User> myObjects = mapper.readValue(new JsonFactory().createJsonParser(file), new TypeReference<List<User>>(){});
		Map<Integer, User> map = new HashMap<>();
		for (User user : myObjects) {
			map.put(user.getId(), user);
		}						
		return map;
	}
	public void writeJsonUserJackson(Collection<User> list) throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(file, list);	
		
	}
}
