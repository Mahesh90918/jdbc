package com.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.connectionUtility.connectionUtility;
import com.mysql.cj.xdevapi.Type;

public class CallableStat {
public static void main(String[] args) {
	Connection con=null;
	CallableStatement call=null;
	
	con=connectionUtility.getConnection(con);
	//System.out.println(con);
	try {
		call=con.prepareCall("{call addd(?,?,?)}");
		call.setInt(1, 10);
		call.setInt(2, 10);
		call.registerOutParameter(3, Types.INTEGER);
		call.execute();
		
		System.out.println("Result "+call.getInt(3));
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
