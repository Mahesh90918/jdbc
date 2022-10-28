package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.empolyee.model.Empolyee;
import com.queries.EmpolyeQueries;
import com.util.ConnectionUtil;

public class EmplImpl implements EmpolyeeDao {

	public List<Empolyee> add(Empolyee[] empolyee) {
		List<Empolyee> list = new ArrayList<Empolyee>();
		Connection con = ConnectionUtil.getConnection();
		try (PreparedStatement ps = con.prepareStatement("INSERT INTO EMPOLYEE VALUES(?,?,?)");) {
			con.setAutoCommit(false);
			for (Empolyee empolyee2 : empolyee) {

				ps.setInt(1, empolyee2.getId());
				ps.setString(2, empolyee2.getName());
				ps.setDouble(3, empolyee2.getSalary());
				list.add(empolyee2);
				ps.addBatch();
			}
			int[] i = ps.executeBatch();
			for (int j : i) {

				System.out.println("INSERT SUCESS" + " " + j);
			}

			return list;

		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection();
		}
		return null;

	}

	public void update(String name, int id) {
		// TODO Auto-generated method stub

	}

	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Empolyee> getAll() {
		List<Empolyee> list = new ArrayList<Empolyee>();
		Connection con = ConnectionUtil.getConnection();
		try (PreparedStatement ps = con.prepareStatement(EmpolyeQueries.RESULTSET); ResultSet rs = ps.executeQuery();) {
			con.setAutoCommit(false);
			while (rs.next()) {
				Empolyee Emp = new Empolyee();
				Emp.setId(rs.getInt(1));
				Emp.setName(rs.getString(2));
				Emp.setSalary(rs.getDouble(3));
				list.add(Emp);

			}
			con.commit();

			return list;

		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return null;
	}
}
