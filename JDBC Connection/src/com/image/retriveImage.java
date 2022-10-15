package com.image;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class retriveImage {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet set = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo ", "root", "root");
			ps = con.prepareStatement("SELECT * FROM image");
			set = ps.executeQuery();
			while (set.next()) {
				System.out.println(set.getInt("id") + " " + set.getString("name") + " " + set.getDate("datee"));
			FileOutputStream file =new FileOutputStream("D:\\\\Yugandhar + Padmavathi\\\\U.Padma\\\\Stills\\\\imageRetrive.jpg");
		     System.out.println(set.getBlob("image"));
		     file.write(set.getBytes("image"));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
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
