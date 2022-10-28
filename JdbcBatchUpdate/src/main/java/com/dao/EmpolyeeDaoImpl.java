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

public class EmpolyeeDaoImpl implements EmpolyeeDao {

	@Override
	public List<Empolyee> add(Empolyee[] empolyee) {
		List<Empolyee> list = new ArrayList<Empolyee>();
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = null;
		try {
			con.setAutoCommit(false);
			ps = con.prepareStatement(EmpolyeQueries.INSERT);
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
		} finally {
			try {
				ConnectionUtil.closeConnection();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;

	}

	@Override
	public void update(String name, int id) {
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = null;

		try {
			con.setAutoCommit(false);
			ps = con.prepareStatement("UPDATE EMPOLYEE SET NAME=? WHERE ID=?");
			ps.setString(1, name);
			ps.setInt(2, id);
			ps.addBatch();
			int update = ps.executeUpdate();
			System.out.println("UPDATE  SUCESS" + " " + update);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ConnectionUtil.closeConnection();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Empolyee> getAll() {
		List<Empolyee> list = new ArrayList<Empolyee>();
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con.setAutoCommit(false);
			ps = con.prepareStatement(EmpolyeQueries.RESULTSET);
			rs = ps.executeQuery(EmpolyeQueries.RESULTSET);
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
		}finally {
			try {
				rs.close();
				ps.close();
				ConnectionUtil.closeConnection();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
