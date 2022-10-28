package com.ciq.cust.ClobBlodTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ciq.util.connectionUtil;

public class read {
	public static void main(String[] args) {
		Connection con = connectionUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("select * from customer");
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getClob(3) + " " + rs.getBlob(4)
						+ " " + rs.getDate(5) + " " + rs.getString(6));
				FileOutputStream clob=new FileOutputStream("D:\\ClobBlod\\mahii.txt");
				clob.write(rs.getBytes(3));
                  FileOutputStream blob=new FileOutputStream("D:\\ClobBlod\\siva.webp");
                  
                  blob.write(rs.getBytes(4));
                  
			}
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
				ps.close();
				rs.close();
				connectionUtil.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
