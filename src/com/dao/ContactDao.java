package com.dao;

import java.util.List;

import com.entity.Contact;

public interface ContactDao {
	public boolean save(Contact contact) ;
	public List<Contact> queryUserByPage(int pageNow,String hostname);
	public boolean delete(Integer id);
	public int countUsers();
}
