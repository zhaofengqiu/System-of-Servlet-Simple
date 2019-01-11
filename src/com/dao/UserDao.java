package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.entity.User;


public interface UserDao {
	public boolean login(String username, String password);
	public boolean save(User user) ;
	public boolean update(User user) ;
	public List<User> queryAll();
	public List<User> queryUserByPage(int pageNow);
	public int countUsers();
	public User queryOne(String hostname);
}
