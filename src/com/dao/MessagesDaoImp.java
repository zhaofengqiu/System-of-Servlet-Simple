package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.entity.Message;
import com.utils.JdbcUtils;


public class MessagesDaoImp implements MessagesDao{
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String hostname;
	public MessagesDaoImp(String hostname){
		this.hostname = hostname;
	}
	public MessagesDaoImp(){
		
	}
	@Override
	public boolean save(Message messages) {
		// TODO Auto-generated method stub
		
		boolean flag = false;
		
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into messages(receiver, content, sender, isread) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, messages.getReceiver());
			pstmt.setObject(2, messages.getContent());
			pstmt.setObject(3, messages.getSender());
			pstmt.setObject(4, messages.getIsread());
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

	@Override
	public List<Message> queryAll() {
		// TODO Auto-generated method stub
		List<Message> messages = new ArrayList<Message>();
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from messages";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String receiver = rs.getString("receiver");
				String content = rs.getString("content");
				String sender = rs.getString("sender");
				int isread = rs.getInt("isread");

				Message message = new Message(id, receiver, content, sender, isread);
				messages.add(message);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		
		return messages; 
	}

	@Override
	public List<Message> queryMessagesByPage(int pageNow) {
		// TODO Auto-generated method stub
		
		int pageCount = 5;
		
		List<Message> messages = new ArrayList<Message>();
		try {
			conn = JdbcUtils.getConnection();
			
			String sql = String.format("select * from messages  where receiver='%s' limit ?,?",this.hostname);
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, (pageNow-1)*pageCount);
			pstmt.setObject(2, pageCount);
			rs = pstmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String receiver = rs.getString("receiver");
				String content = rs.getString("content");
				String sender = rs.getString("sender");
				int isread = rs.getInt("isread");
				Message message = new Message(id, receiver, content, sender, isread);
				messages.add(message);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		
		return messages; 
	}

	@Override
	public int countMessages() {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			conn = JdbcUtils.getConnection();
			String sql = String.format("select count(*) from messages where receiver='%s' ",this.hostname);
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
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		
		try {
			conn = JdbcUtils.getConnection();
			
			String sql = "delete from messages where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, id);	
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
	public boolean update_status(int id){
		// TODO Auto-generated method stub
		boolean flag = false;
		
		try {
			conn = JdbcUtils.getConnection();
			
			String sql = "update messages set isread ='1' where id=?";
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
