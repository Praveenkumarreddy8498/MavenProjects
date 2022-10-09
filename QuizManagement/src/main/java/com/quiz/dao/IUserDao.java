package com.quiz.dao;

import com.quiz.model.User;

/**
 * @author PraveenKumarReddy
 *
 */
public interface IUserDao {
	/**
	 * This Method is used to add the user to Database
	 * 
	 * @param user for passing user
	 * @return String of Auto Generated Password
	 */
	String addUser(User user);

	/**
	 * This method is used to find the User in Database
	 * 
	 * @param userName for passing user name
	 * @param password for passing password
	 * @param role     for passing role
	 * @return User from Database
	 */
	User findByUserName(String userName, String password, String role);

	/**
	 * This Method is Used to Change the password based on parameters
	 * 
	 * @param userName for passing user name
	 * @param password for passing password
	 * @param role     for passing role
	 * @return integer from executeUpdate
	 */
	int changePassword(String userName, String password, String role);

}
