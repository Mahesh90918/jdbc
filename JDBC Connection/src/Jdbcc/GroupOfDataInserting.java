package Jdbcc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GroupOfDataInserting {
// DML=INSERT,DELETE,UPDATE  is executeUpdate method
	public static void main(String[] args) {
		Connection con = null;
		Statement sta = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo ", "root", "root");
			sta = con.createStatement();
			sta.addBatch("INSERT INTO EMPOLYEE VALUES(01,'MAHESH1',25000) ");
			sta.addBatch("INSERT INTO EMPOLYEE VALUES(02,'MAHESH2',25000) ");
			sta.addBatch("INSERT INTO EMPOLYEE VALUES(03,'MAHESH3',25000) ");
			sta.addBatch("INSERT INTO EMPOLYEE VALUES(04,'MAHESH4',25000) ");
			int arr[] = sta.executeBatch();
			for (int i : arr) {
				System.out.println(i);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				sta.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
