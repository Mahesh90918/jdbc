package com.ciq.cust.ClobBlodTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import com.ciq.util.connectionUtil;

public class ClobBlodTest {
	public static void main(String[] args) {
		Connection con = connectionUtil.getConnection();
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement("insert into customer values(?,?,?,?,?,?)");
			ps.setInt(1, 02);
			ps.setString(2, "mysql2");
			FileReader file = new FileReader("D:\\mahi.txt");
			ps.setClob(3, file);
			FileInputStream inputStream = new FileInputStream("D:\\1102051.webp");
			ps.setBlob(4, inputStream);
			SimpleDateFormat simple = new SimpleDateFormat("yyyy-mm-dd");
			java.util.Date util = simple.parse("2022-9-09");
			Date sql = new Date(util.getDate());
			ps.setDate(5, sql);
			ps.setString(6, "lordsiva");
			ps.addBatch();
			int[] i = ps.executeBatch();
			System.out.println(Arrays.toString(i));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				connectionUtil.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
