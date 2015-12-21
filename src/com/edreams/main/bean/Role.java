package com.edreams.main.bean;

import com.edreams.main.dao.ROLE_TYPES;

public class Role implements IRole{
	private String type;
		
	public Role(String type) {
		super();
		this.type = type;
	}
	@Override
	public String getType() {
		return type;
	}

	@Override
	public boolean isManager() {
		return ROLE_TYPES.MANAGER.equals(type);
	}

	@Override
	public String toString() {
		return (type != null ? type : "");
	}
	
	

}
