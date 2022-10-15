package com.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.connectionUtility.connectionUtility;

public class empol {
	public static void main(String[] args) {
		Connection con = null;
		CallableStatement call = null;

		con = connectionUtility.getConnection(con);
		// System.out.println(con);
		try {
			call = con.prepareCall("{call insertempolyee(?,?,?)}");
			call.setInt(1, 16);
			call.setString(2, "mahesh");
			call.setDouble(3, 12345);
			call.execute();
			System.out.println("sucess");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
