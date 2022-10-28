package com.image.Customer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import com.ciq.cust.util.Customer;
import com.ciq.util.connectionUtil;

public class Customerdata {
	public static void main(String[] args) {
		Connection con = connectionUtil.getConnection();
		
		PreparedStatement ps = null;
		
		
      // Customer cus=new Customer(03, "sp3",load, inputStream, sql, "sivaaaa");
		try {
			FileReader file = new FileReader("D:\\mahi.txt");
			FileInputStream inputStream = new FileInputStream("D:\\1102051.webp");
			SimpleDateFormat simple = new SimpleDateFormat("yyyy-mm-dd");
			java.util.Date util = simple.parse("2022-9-09");
			Date sql = new Date(util.getDate());
			Customer  cus=new Customer();
			ps = con.prepareStatement("insert into customer values(?,?,?,?,?,?)");
			ps.setInt(1, cus.getId());
			ps.setString(2, cus.getConceptName());
			ps.setClob(3, cus.getFile());
			ps.setBlob(4, cus.getLogo());
			ps.setDate(5, (java.sql.Date) cus.getCreation_date());
			ps.setString(6, cus.getComments());
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
