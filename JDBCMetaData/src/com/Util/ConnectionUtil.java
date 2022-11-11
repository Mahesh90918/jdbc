package com.Util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.protocol.Resultset;

public class ConnectionUtil {

	private static Connection connection = null;

	private static Properties properties = new Properties();
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			properties.load(ConnectionUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			connection = DriverManager.getConnection(properties.getProperty("mysql.url"),
					properties.getProperty("mysql.user"), properties.getProperty("mysql.password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Connection getConnection() {
		return connection;

	}

	public static void close(Connection connection) {

		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void close(Statement statement, Connection connection) {

		try {
			if (statement != null) {
				statement.close();
				close(connection);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void close(ResultSet resultSet, Statement statement, Connection connection) {

		try {
			if (resultSet != null) {
				resultSet.close();
				close(statement, connection);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		System.out.println(ConnectionUtil.getConnection());
	}

}
