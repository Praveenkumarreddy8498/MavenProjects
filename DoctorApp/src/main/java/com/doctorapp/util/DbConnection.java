package com.doctorapp.util;

import java.sql.*;


public class DbConnection {
	static Connection connection;
	public static Connection getConnection() {
		String url="jdbc:mysql://localhost:3306/doctordb";
		String user="root";
		String password="pass123";
		connection=null;
		
		try {
			connection =DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
		
	}
	public static void closeConnection() {
		if(connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
