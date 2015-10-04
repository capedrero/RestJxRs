package com.edreams.main.model;

import java.util.Collection;

import com.edreams.main.bean.User;
import com.edreams.main.dao.ManagerUserDB;

public class ModelUserService {

	private ManagerUserDB dao;	

	public ModelUserService() {
		super();
		this.dao = new ManagerUserDB();		
	}

	public void startDB() throws Exception{			
		this.dao.startDB();
	}

	public User getUser(final Integer id) {
		return dao.getUser(id);
	}

	public Collection<User> getUsers() {
		return dao.getUsers();
	}

	public void deleteUser(User user) throws Exception {
		dao.deleteUser(user);
	}

	public void insertUser(User user) throws Exception {
		dao.insertUser(user);
	}

	public void updateUser(User user) throws Exception {
		dao.updateUser(user);
	}
	

	
	
}
