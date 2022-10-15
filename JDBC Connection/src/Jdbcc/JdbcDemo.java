
package Jdbcc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		try {
			// register driver (com.mysql.cj.jdbc.Driver)
			Class.forName("com.mysql.cj.jdbc.Driver");
			// create connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo ", "root", "root");
			System.out.println(connection);
			// create statement
			statement = connection.createStatement();
			System.out.println(statement);
			// execute quary
			int result1 = statement.executeUpdate("INSERT INTO EMPOLYEE VALUES(01,'MAHESH',25000) ");
			int result2 = statement.executeUpdate("INSERT INTO EMPOLYEE VALUES(02,'SRIMAN',25000) ");
			int result3 = statement.executeUpdate("INSERT INTO EMPOLYEE VALUES(03,'SHAN',25000) ");
			int result4 = statement.executeUpdate("INSERT INTO EMPOLYEE VALUES(04,'MAHESH',25000) ");
			System.out.println(result1);
			System.out.println(result2);
			System.out.println(result3);
			System.out.println(result4);

//			statement.executeUpdate("delete from empolyee where id=01");
			System.out.println("sucess");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// close connections
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
