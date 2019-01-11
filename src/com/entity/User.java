package com.entity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class User {
	
	private int id;
	private String name;
	private String password;
	private String email;
	private String phone ;
	private String youbian;
	
	public User(){}
	
	public User(int id, String name, String password,String phone, String email,String youbian) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.youbian = youbian;
	}
	public User(String name, String password,String phone, String email,String youbian) {
		super();
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.youbian = youbian;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getYoubian() {
		return youbian;
	}

	public void setYoubian(String youbian) {
		this.youbian = youbian;
	}

	
	
}
