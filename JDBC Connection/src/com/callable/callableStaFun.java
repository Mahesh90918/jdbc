package com.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.connectionUtility.connectionUtility;

public class callableStaFun {
	public static void main(String[] args) {
		Connection con = null;
		CallableStatement call = null;

		con = connectionUtility.getConnection(con);
		// System.out.println(con);
		try {
			call = con.prepareCall("{?= call sub(?,?)}");
			call.registerOutParameter(1, Types.INTEGER);
			call.setInt(2, 50);
			call.setInt(3, 10);
			call.execute();
			System.out.println("fun result :"+call.getInt(1));


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
