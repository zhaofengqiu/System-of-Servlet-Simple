package com.entity;

public class Contact {
	
	private int id;
	private String hostname;
	private String name;
	private String sex;
	private String phone ;
	private String email;
	private String qq ;
	private String workspace ;
	private String address ;
	private String postcode;
	
	public Contact(){}
	
	public Contact(int id, String hostname,String name, String sex,String phone, String email,String qq,String workspace,String address,String postcode) {
		super();
		this.id = id;
		this.hostname = hostname;
		this.name = name;
		this.sex=sex;
		this.phone = phone;
		this.email = email;
		this.qq=qq;
		this.workspace=workspace;
		this.address = address;
		this.postcode = postcode;
	}
	public Contact(String hostname,String name, String sex,String phone, String email,String qq,String workspace,String address,String postcode)  {
		super();
		this.hostname = hostname;
		this.name = name;
		this.sex=sex;
		this.phone = phone;
		this.email = email;
		this.qq=qq;
		this.workspace=workspace;
		this.address = address;
		this.postcode = postcode;
	}
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWorkspace() {
		return workspace;
	}

	public void setWorkspace(String workspace) {
		this.workspace = workspace;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	
	
}