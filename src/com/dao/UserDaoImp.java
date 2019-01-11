package com.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.entity.User;
import com.utils.JdbcUtils;


public class UserDaoImp implements UserDao{
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Override
	public boolean login(String username, String password)  {
		// TODO Auto-generated method stub
		boolean flag = false;//���λ��Ĭ��Ϊfalse
		
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from accounts where USERNAME = ? and PASSWORD = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, username);
			pstmt.setObject(2, password);
			System.out.println(pstmt);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				flag = true; //���������ǿգ�˵�����û�ƥ�䣨�û���������ȷ��
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		
		return flag; //���ر��
	}

	@Override
	public boolean save(User user) {
		// TODO Auto-generated method stub
		
		boolean flag = false;
		
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into accounts( USERNAME,PASSWORD , EMAIL,PHONE, YOUBIAN) values(?,?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, user.getName());
			pstmt.setObject(2, user.getPassword());
			pstmt.setObject(3, user.getEmail());
			pstmt.setObject(4, user.getPhone());
			pstmt.setObject(5, user.getYoubian());
			if(pstmt.executeUpdate() > 0) {
				flag = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		 int n = 0;
        try {
    		FileInputStream fis = new FileInputStream("C:\\Users\\asus\\Desktop\\Javacode\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\sm\\images\\"+"moren.jpg");
            FileOutputStream fos = new FileOutputStream("C:\\Users\\asus\\Desktop\\Javacode\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\sm\\images\\"+ user.getName()+".jpg");

            byte[] bs = new byte[1024*1024]; 
			while ((n = fis.read(bs)) != -1) {
			    fos.write(bs,0,n);
			}
			fis.close();
	        fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag=false;
		}
	  
		return flag;
		
	}
	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		boolean flag = false;
		System.out.println( user.getName());
		try {
			
			conn = JdbcUtils.getConnection();
			
			
			
			
			String sql1 = "select * from accounts where ID=?";
			pstmt = conn.prepareStatement(sql1);
			System.out.println(pstmt);
			pstmt.setObject(1, user.getId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String img_name = rs.getString("USERNAME");
				int n = 0;
		        try {
		    		FileInputStream fis = new FileInputStream("C:\\Users\\asus\\Desktop\\Javacode\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\sm\\images\\"+img_name+".jpg");
		            FileOutputStream fos = new FileOutputStream("C:\\Users\\asus\\Desktop\\Javacode\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\sm\\images\\"+ user.getName()+".jpg");
		            System.out.println("C:\\Users\\asus\\Desktop\\Javacode\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\sm\\images\\"+img_name+".jpg");
		            System.out.println("C:\\Users\\asus\\Desktop\\Javacode\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\sm\\images\\"+ user.getName()+".jpg");
		            byte[] bs = new byte[1024*1024]; 
					while ((n = fis.read(bs)) != -1) {
					    fos.write(bs,0,n);
					}
					fis.close();
			        fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					flag=false;
					return flag;
				}
			}
			String sql2 = "UPDATE accounts  set  PASSWORD=? , EMAIL=? , PHONE =?, YOUBIAN=? ,USERNAME= ?  where ID = ?";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setObject(1, user.getPassword());
			pstmt.setObject(2, user.getEmail());
			pstmt.setObject(3, user.getPhone());
			pstmt.setObject(4, user.getYoubian());
			pstmt.setObject(5, user.getName());
			pstmt.setObject(6, user.getId());
		
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
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from accounts";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("ID");
				String name = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				String youbian = rs.getString("YOUBIAN");
				User user = new User(id,name, password, phone, email,youbian);
				
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		
		return users; 
	}

	@Override
	public List<User> queryUserByPage(int pageNow) {
		// TODO Auto-generated method stub
		
		int pageCount = 4;
		
		List<User> users = new ArrayList<User>();
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from accounts limit ?, ?";
				
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setObject(1, (pageNow-1)*pageCount);
			pstmt.setObject(2, pageCount);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				int id = rs.getInt("ID");
				String name = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				String youbian = rs.getString("YOUBIAN");
				System.out.println(name);
				User user = new User(id,name, password, phone, email,youbian);
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		
		return users; 
	}

	@Override
	public User queryOne(String hostname) {
		// TODO Auto-generated method stub
		User user = null ;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from accounts where USERNAME=?";	
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, hostname);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				String youbian = rs.getString("YOUBIAN");
				System.out.println(id);
				user = new User(id,name, password, phone, email,youbian);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
	@Override
	public int countUsers() {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select count(*) from accounts";
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

	
	

	

}
