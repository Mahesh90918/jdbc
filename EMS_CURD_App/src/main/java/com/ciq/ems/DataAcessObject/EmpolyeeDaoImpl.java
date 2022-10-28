package com.ciq.ems.DataAcessObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ciq.ems.model.Empolyee;
import com.ciq.ems.queries.EmpolyeeQueries;
import com.ciq.ems.util.connectionUtil;

public class EmpolyeeDaoImpl implements EmpolyeeDao {

	public void add(Empolyee emp) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = connectionUtil.getConnection();
			ps = con.prepareStatement(EmpolyeeQueries.INSERT_EMP);
			ps.setInt(1, emp.getId());
			ps.setString(2, emp.getName());
			ps.setDouble(3, emp.getSalary());
			int exe = ps.executeUpdate();
			System.out.println(exe);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			connectionUtil.closeStatement(ps);
		}

	}

	public void update(Empolyee empolyee) {
	

	}

	public int delete(int id) {
		try {
			Connection con = connectionUtil.getConnection();
			PreparedStatement st = con.prepareStatement("DELETE FROM EMPOLYEE WHERE ID=?");
			st.setInt(1, id);
			int i = st.executeUpdate();
			System.out.println(i);
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public List<Empolyee> getAll() {
		List<Empolyee> list = new ArrayList<Empolyee>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = connectionUtil.getConnection();
			ps = con.prepareStatement(EmpolyeeQueries.SELECT_ALL_EMP);
			rs = ps.executeQuery();
			while (rs.next()) {
				Empolyee e = new Empolyee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getDouble(3));
				list.add(e);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
