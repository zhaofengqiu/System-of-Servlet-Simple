package com.entity;

import java.util.Date;

public class Message {
	
	private int id;
	private String receiver;
	private String content;
	private String sender;
	private int isread;
	
	
	public Message(){}
	public Message(int id,String receiver, String content, String sender, int isread ) {
		super();
		this.id = id;
		this.receiver = receiver;
		this.content = content;
		this.sender = sender;
		this.isread = isread;
	}
	public Message(String receiver, String content, String sender, int isread ) {
		super();
		this.receiver = receiver;
		this.content = content;
		this.sender = sender;
		this.isread = isread;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public int getIsread() {
		return this.isread;
	}

	public void setIsread(int isread) {
		this.isread = isread;
	}


	
}
