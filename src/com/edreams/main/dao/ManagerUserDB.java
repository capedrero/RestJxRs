package com.edreams.main.dao;

import java.io.File;
import java.util.Collection;
import java.util.Map;

import com.edreams.main.bean.User;
import com.edreams.main.dao.json.JsonUserManager;

public class ManagerUserDB implements IManagerUserDB{
	private Map<Integer, User> userTable;
	private JsonUserManager jsonManager;

	
	public ManagerUserDB() {
		super();
		jsonManager = new JsonUserManager(new File(System.getProperty("user.home")+"\\Users.json"));
	}
	
	public void startDB() throws Exception{
		userTable = jsonManager.readJsonUserJackson();
	}
	
	@Override
	public Collection<User> getUsers() {
		return userTable.values();
	}
	@Override
	public User getUser(final Integer id) {
		return userTable.get(id);
	}
	@Override
	public void insertUser(User user) throws Exception {
		user.setId(userTable.size()+1);
		userTable.put(user.getId(), user);
		jsonManager.writeJsonUserJackson(userTable.values());
		
	}
	@Override
	public void deleteUser(User user) throws Exception {
		userTable.remove(user.getId());
		jsonManager.writeJsonUserJackson(userTable.values());
		
	}
	@Override
	public void updateUser(User user) throws Exception {
		userTable.put(user.getId(), user);
		jsonManager.writeJsonUserJackson(userTable.values());
	}
	
	
}
