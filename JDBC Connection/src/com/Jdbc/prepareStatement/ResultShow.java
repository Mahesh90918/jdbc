package com.Jdbc.prepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultShow {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet set = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo ", "root", "root");
			ps = con.prepareStatement("SELECT * FROM EMPOLYEE");
			set = ps.executeQuery();
			while (set.next()) {
				System.out.println(set.getInt("id") + " " + set.getString("name") + " " + set.getDouble("salary"));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				set.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
