package com.masaischool.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtils {

	
	static Connection getConnectionTodatabase() throws SQLException, ClassNotFoundException {
		//step-1: load the Driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		//step-2
		ResourceBundle rb = ResourceBundle.getBundle("dbdetails");
		return DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("password"));
	}
	static void closeConnection(Connection conn) throws SQLException {
		if(conn != null)
			conn.close();
	}
	static boolean isResultSetEmpty(ResultSet rs) throws SQLException {
		if(!rs.isBeforeFirst() && rs.getRow() == 0)
			return true;
		return false;
	}
}
