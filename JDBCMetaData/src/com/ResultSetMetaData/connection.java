package com.ResultSetMetaData;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import com.Util.ConnectionUtil;

public class connection {
	public static void main(String[] args) {
		Connection con = ConnectionUtil.getConnection();
		Statement stml;
		try {
			stml = con.createStatement();
			ResultSet rs = stml.executeQuery("SELECT * FROM EMPOLYEE");
			ResultSetMetaData rsmd = rs.getMetaData();
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				System.out.println("column name:" + rsmd.getColumnName(i));

				int CType = rsmd.getColumnType(i);
				if (CType == Types.INTEGER) {
					System.out.println("column type:INTERGER");
				}

				if (CType == Types.VARCHAR) {
					System.out.println("column type:VARCHAR");
				}

				if (CType == Types.DECIMAL) {
					System.out.println("column type:DECIMAL");
				}
				if (CType == Types.DATE) {
					System.out.println("column type:DATE");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
