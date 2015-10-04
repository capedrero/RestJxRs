package com.edreams.test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Assert;
import org.junit.Test;

import com.edreams.main.bean.User;
import com.edreams.main.dao.ManagerUserDB;
import com.edreams.main.dao.json.JsonUserManager;



public class TestFileJson {
	
	@Test
	public void testReadFileUsersJackson(){
		try{
			ObjectMapper mapper = new ObjectMapper();
			List<User> myObjects = mapper.readValue(new JsonFactory().createJsonParser(new File(System.getProperty("user.home")+"\\Users.json")), new TypeReference<List<User>>(){});			
			for (User user : myObjects) {
				System.out.println(user.toString());
			}
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
						
	}
	@Test
	public void testWriteFileUsersJackson(){
		try{
			String input = "{\"id\":\"1\",\"address\":\"Madrid\",\"age\":\"33\",\"gender\":\"Male\",\"name\":\"Mario\",\"surName\":\"Pedrero\",\"role\":\"USER\"}";
			User user = new ObjectMapper().readValue(input, User.class);
			User user2   = new ObjectMapper().readValue(input, User.class);
			user2.setId(2);
			new JsonUserManager(new File("c:\\Users2.json")).writeJsonUserJackson(Arrays.asList(new User[]{user, user2}));
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
						
	}

	@Test
	public void testDao(){
		try{
				ManagerUserDB dao = new ManagerUserDB();
				dao.startDB();				
				for (User user : dao.getUsers()) {
					System.out.println(user.getName());
				}
			
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
						
	}
}
