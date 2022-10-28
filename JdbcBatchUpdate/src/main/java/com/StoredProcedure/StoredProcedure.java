package com.StoredProcedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.util.ConnectionUtil;

public class StoredProcedure {
	public static void main(String[] args) {

		Connection con = ConnectionUtil.getConnection();

		CallableStatement insert = null;
//		CallableStatement update = null;
//		CallableStatement delete = null;

		try {
			con.setAutoCommit(false);
			insert = con.prepareCall("{call Empolyee_update(?,?)}");
			insert.setString(1, "padma");
			insert.setInt(2, 98);
			int i = insert.executeUpdate();
			System.out.println(i);
			
//			update=con.prepareCall("");
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
//				delete.close();
//				update.close();
				insert.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
