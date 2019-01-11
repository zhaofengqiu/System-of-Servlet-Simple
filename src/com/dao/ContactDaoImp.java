package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Contact;
import com.entity.User;
import com.utils.JdbcUtils;

public class ContactDaoImp implements ContactDao{
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Override
	public boolean save(Contact contact) {
		boolean flag = false;
		
		try {
			conn = JdbcUtils.getConnection();
			
			String sql = "insert into contacts( hostname , name,sex, phone,email,qq,workspace,address,postcode) values(?,?,?, ?, ?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, contact.getHostname());
			pstmt.setObject(2, contact.getName());
			pstmt.setObject(3, contact.getSex());
			pstmt.setObject(4, contact.getPhone());
			pstmt.setObject(5, contact.getEmail());
			pstmt.setObject(6, contact.getQq());
			pstmt.setObject(7, contact.getWorkspace());
			pstmt.setObject(8, contact.getAddress());
			pstmt.setObject(9, contact.getPostcode());
			
			if(pstmt.executeUpdate() > 0) {
				flag = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		
		return flag;
		
	}

	@Override
	public List<Contact> queryUserByPage(int pageNow,String hostname) {

		int pageCount = 4;
		
		List<Contact> contacts = new ArrayList<Contact>();
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from contacts where hostname=? limit ?, ?";
				
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, hostname);
			pstmt.setObject(2, (pageNow-1)*pageCount);
			pstmt.setObject(3, pageCount);
			rs = pstmt.executeQuery();
			while(rs.next()){
				//int id, String hostname,String name, String sex,String phone
				//, String email,String qq,String workspace,String address,String postcode
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String qq = rs.getString("qq");
				String workspace = rs.getString("workspace");
				String address = rs.getString("address");
				String postcode = rs.getString("postcode");
				Contact contact = new Contact(id,hostname, name, sex, phone,email,qq,workspace,address,postcode);
				contacts.add(contact);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		
		return contacts; 
	}

	@Override
	public int countUsers() {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select count(*) from contacts";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		
		return count; 
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		
		try {
			conn = JdbcUtils.getConnection();
			
			String sql = "delete from contacts where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, id);	
			System.out.println(pstmt);
			if(pstmt.executeUpdate() > 0) {
				flag = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		
		return flag;
	}

}
