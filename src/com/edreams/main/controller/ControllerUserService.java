package com.edreams.main.controller;

import java.util.Collection;

import com.edreams.main.bean.User;
import com.edreams.main.model.ModelUserService;

public class ControllerUserService {

	private ModelUserService modelUserService;
	
	public ControllerUserService() {
		super();			
		modelUserService = new ModelUserService();
	}
	
	public void startDB() throws Exception {		
		this.modelUserService.startDB();
		
	}

	public Collection<User> getUsers() {
		return modelUserService.getUsers();
	}

	public User getUser(final Integer id) {
		return modelUserService.getUser(id);
	}

	public void deleteUser(User user) throws Exception {
		 modelUserService.deleteUser(user);
	}

	public void insertUser(User user) throws Exception {
		 modelUserService.insertUser(user);
	}

	public void updateUser(User user) throws Exception {
		 modelUserService.updateUser(user);
	}		
	
}
