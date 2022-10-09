package com.quiz.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author PraveenKumarReddy
 *
 */
public class DbConnection {
	static Connection connection;
	/**This Method opens the Connection for connecting to database
	 * @return connection
	 */
	public static Connection openConnection() {
		String url="jdbc:mysql://localhost:3306/quizdb";
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
	/**
	 * This Method closes the Connection for connecting to database
	 */
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
