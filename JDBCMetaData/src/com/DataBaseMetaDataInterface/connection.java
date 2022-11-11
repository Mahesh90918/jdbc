package com.DataBaseMetaDataInterface;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.Util.ConnectionUtil;

public class connection {
public static void main(String[] args) {
	
	
	try {
		Connection con=ConnectionUtil.getConnection();
		DatabaseMetaData data=con.getMetaData();
		System.out.println(data.getDatabaseMajorVersion());
		System.out.println(data.getDatabaseMinorVersion());
		System.out.println(data.getUserName());
		System.out.println(data.getDriverMajorVersion());
		System.out.println(data.getDriverMinorVersion());
		System.out.println(data.getDriverVersion());
		System.out.println(data.getDriverName());
		System.out.println(data.getMaxRowSize());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
