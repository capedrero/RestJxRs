package com.edreams.main.bean;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;



@XmlRootElement
public class User {
	private Integer id;
	private String name;
	private String surName;
	private String address;
	private String gender;
	private Integer age;
	private IRole role;

	public User() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}


	public String getRole() {
		return (role!=null)?role.toString():"";
	}

	public void setRole(String srole) {
		this.role = new Role(srole);
	}
	@JsonIgnore
	public boolean isManager(){
		return role.isManager();
	}

	@Override
	public String toString() {
		return "User [" + (name != null ? "name=" + name + ", " : "")
				+ (surName != null ? "surName=" + surName + ", " : "")
				+ (address != null ? "address=" + address + ", " : "")
				+ (gender != null ? "gender=" + gender + ", " : "") + (age != null ? "age=" + age + ", " : "")
				+ (role != null ? "role=" + role.getType() : "") + "]";
	}
	

}
