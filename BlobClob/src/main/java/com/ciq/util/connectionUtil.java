package com.ciq.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class connectionUtil {
// Empolyee management system
	// dao=data acess object
	private static Connection connection = null;
	private static Statement ps = null;
	private static ResultSet rs = null;
	private static Properties properties = null;
	

	static {
		
			
			
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "root");
			
		properties = new Properties();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			properties.load(connectionUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			connection = DriverManager.getConnection(properties.getProperty("Url"), properties.getProperty("user"),
					properties.getProperty("password"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	
		
		
	}

	public static Connection getConnection() {
		return connection;
	}

	public static void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void closeStatement(Statement sta) {
		try {
			connectionUtil.closeConnection();
			sta.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void closeResultSet(Statement sta, ResultSet rs) {
		try {
			connectionUtil.closeStatement(sta);
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
	
		System.out.println(getConnection());
	}

}
