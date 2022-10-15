package com.Jdbc.prepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupOfDataInserting {
// DML=INSERT,DELETE,UPDATE  is executeUpdate method
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		List<Empolyee> al = new ArrayList<Empolyee>();
		al.add(new Empolyee(10, "ms", 15000));
		al.add(new Empolyee(11, "gs", 15000));
		al.add(new Empolyee(12, "ns", 15000));
		al.add(new Empolyee(13, "ts", 15000));
		al.add(new Empolyee(15, "ys", 15000));

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo ", "root", "root");
			ps = con.prepareStatement("INSERT INTO EMPOLYEE VALUES(?,?,?) ");

			for (Empolyee emp : al) {
				ps.setInt(1, emp.getId());
				ps.setString(2, emp.getName());
				ps.setDouble(3, emp.getSalary());
				ps.addBatch();// must
			}

			int arr[] = ps.executeBatch();
			for (int i : arr) {
				System.out.println(i);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
