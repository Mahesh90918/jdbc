package com.BatchUpdate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import com.empolyee.model.Empolyee;
import com.queries.EmpolyeQueries;
import com.util.ConnectionUtil;

public class BatchUpdate {

	public static void main(String[] args) {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement ps = null;
		PreparedStatement psupdate = null;
		PreparedStatement psdelete = null;
		ResultSet set = null;
		try {
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(EmpolyeQueries.INSERT);

			ps.setInt(1, 01);
			ps.setString(2, "siva");
			ps.setDouble(3, 45000);
			ps.addBatch();
			
			ps.setInt(1, 04);
			ps.setString(2, "shankar");
			ps.setDouble(3, 45000);
			ps.addBatch();

			ps.setInt(1, 05);
			ps.setString(2, "siva");
			ps.setDouble(3, 45000);
			ps.addBatch();

			ps.setInt(1, 06);
			ps.setString(2, "mahesh");
			ps.setDouble(3, 45000);
			ps.addBatch();

			psupdate = connection.prepareStatement(EmpolyeQueries.UPDATE);
			psupdate.setString(1, "subbu");
			psupdate.setDouble(2, 3333);
			psupdate.setInt(3, 01);
			psupdate.addBatch();

			psdelete = connection.prepareStatement(EmpolyeQueries.DELETE);
			psdelete.setInt(1, 06);
			psdelete.addBatch();

			int[] insert = ps.executeBatch();
			System.out.println(Arrays.toString(insert));
			int[] update = psupdate.executeBatch();
			System.out.println(Arrays.toString(update));
			int[] delete = psdelete.executeBatch();
			System.out.println(Arrays.toString(delete));

			System.out.println("result set");
			set = ps.executeQuery(EmpolyeQueries.RESULTSET);
			while (set.next()) {
				System.out.println(set.getInt(1) + " " + set.getString(2) + " " + set.getDouble(3));
			}
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				ConnectionUtil.closeConnection();
				ps.close();
				psupdate.close();
				set.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
