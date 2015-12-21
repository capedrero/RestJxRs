package com.edreams.main.dao.json;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.edreams.main.bean.User;
import com.edreams.main.dao.CommandObjectReaderList;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUserManager {
	private File file;
	
	
	public JsonUserManager(File file) {
		super();
		this.file = file;
	}

	public Map<Integer, User> readJsonUserJackson() throws Exception{
		//ObjectMapper mapper = new ObjectMapper();
		//List<User> myObjects = mapper.readValue(new JsonFactory().createJsonParser(file), new TypeReference<List<User>>(){});
		List<User> myObjects = new CommandObjectReaderList().processRoot(null, List.class, User.class).readValue(file);
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
