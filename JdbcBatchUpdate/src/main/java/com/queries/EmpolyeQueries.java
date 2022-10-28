package com.queries;

public interface EmpolyeQueries {
	static String INSERT = "INSERT INTO EMPOLYEE VALUES(?,?,?)";
	static String DELETE = "DELETE FROM EMPOLYEE WHERE ID=?";
	static String UPDATE = "UPDATE EMPOLYEE SET NAME=? ,SALARY=? WHERE ID=?";
	static String RESULTSET = "SELECT * FROM EMPOLYEE";
}
