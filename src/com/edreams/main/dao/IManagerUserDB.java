package com.edreams.main.dao;

import java.util.Collection;

import com.edreams.main.bean.User;

public interface IManagerUserDB {
	
	Collection<User> getUsers();
	
	User getUser(final Integer id);
	
	void insertUser(final User user) throws Exception;
	
	void updateUser(final User user) throws Exception;
	
	void deleteUser(final User user) throws Exception;
	
}
