package com.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.model.Department;

public class DbUtil {
	
	private static final String URL = "jdbc:mysql://localhost:3306/office";
	private static String USERNAME = "root";
	private static String PASSWORD = "babysree@6281";
	
	
	public final static Connection getConnection() {
		Connection connection = null;
		 try
		 {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		 }
		 catch (ClassNotFoundException e) 
		 {
			e.printStackTrace();
		 }
	     catch (SQLException e)
		 {
			e.printStackTrace();
		}
		 return connection;
	 }


	
	
}












