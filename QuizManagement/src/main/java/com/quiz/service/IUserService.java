package com.quiz.service;

import com.quiz.exception.UserNotFoundException;
import com.quiz.model.User;

/**
 * @author PraveenKumarReddy
 *
 */
public interface IUserService {
	/**
	 * This Method pass the values to dao object after generating password, will get
	 * the return value
	 * 
	 * @param user for passing user
	 * @return String auto-generated password
	 */
	String register(User user);

	/**
	 * This Method pass the values to dao object, will get the return value
	 * 
	 * @param userName for passing user name
	 * @param password for passing password
	 * @param role     for passing role
	 * @return user for passing use
	 * @throws UserNotFoundException when the user is not found
	 */
	User login(String userName, String password, String role) throws UserNotFoundException;

	/**
	 * This Method pass the values to dao object, will get the return value
	 * 
	 * @param userName for passing user name
	 * @param password for passing password
	 * @param role     for passing role
	 * @throws UserNotFoundException when the user is not found
	 */
	void changePassword(String userName, String password, String role) throws UserNotFoundException;

}
