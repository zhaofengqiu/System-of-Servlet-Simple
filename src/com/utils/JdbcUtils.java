package com.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
	private static String driver = null;
	private static String url = null;
	private static String username = null;
	private static String password = null;
	
	//static ��̬����飬�������ʱ��ִ��һ�Σ���1��
	static {
		try {
			// ��ȡdb.properties�ļ��е����ݿ�������Ϣ
			InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
			Properties prop = new Properties();
			prop.load(in);

			// ��ȡ���ݿ���������
			driver = prop.getProperty("driver");
			// ��ȡ���ݿ�����URL��ַ
			url = prop.getProperty("url");
			// ��ȡ���ݿ������û���
			username = prop.getProperty("username");
			// ��ȡ���ݿ���������
			password = prop.getProperty("password");

			// �������ݿ�����
			Class.forName(driver);

		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	/**
	 * @Method: getConnection
	 * @Description: ��ȡ���ݿ����Ӷ���
	 * @Anthor:�°�����
	 *
	 * @return Connection���ݿ����Ӷ���
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

	/**
	 * @Method: release
	 * @Description: �ͷ���Դ��
	 *               Ҫ�ͷŵ���Դ����Connection���ݿ����Ӷ��󣬸���ִ��SQL�����PreparedStatement���󣬴洢��ѯ�����ResultSet����
	 * @Anthor:Jason
	 *
	 * @param conn
	 * @param st
	 * @param rs
	 */
	public static void release(Connection conn, PreparedStatement st, ResultSet rs) {
		if (rs != null) {
			try {
				// �رմ洢��ѯ�����ResultSet����
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if (st != null) {
			try {
				// �رո���ִ��SQL�����Statement����
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				// �ر�Connection���ݿ����Ӷ���
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
