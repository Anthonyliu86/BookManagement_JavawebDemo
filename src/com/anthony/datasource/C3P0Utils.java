package com.anthony.datasource;
 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
import com.mchange.v2.c3p0.ComboPooledDataSource;
 
public class C3P0Utils {
	
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	public static ComboPooledDataSource getDataSource() {
		return dataSource;
	}
 
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError("��ʼ��ʧ�ܣ����������ļ�");
		}
	}
	
	public static void release(Connection conn, Statement stmt, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null; //�Ͻ���������
		}
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
 
}