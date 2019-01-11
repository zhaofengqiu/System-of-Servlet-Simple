package com.test;

import java.sql.SQLException;

import com.utils.JdbcUtils;

public class TestJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println(JdbcUtils.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
