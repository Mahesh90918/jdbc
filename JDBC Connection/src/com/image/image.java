package com.image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class image {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement sta = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo ", "root", "root");
			sta = con.prepareStatement("insert into image values(?,?,?,?)");

			FileInputStream photo = new FileInputStream("D:\\Yugandhar + Padmavathi\\U.Padma\\Stills\\ys.jpg");
			sta.setInt(1, 1);
			sta.setString(2, "mahesh");
			sta.setBlob(3, photo);
			Date date= new Date("2022/12/09");
			java.sql.Date dd=new java.sql.Date(date.getTime());
			sta.setDate(4, dd);
			sta.execute();
			System.out.println("sucess");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
