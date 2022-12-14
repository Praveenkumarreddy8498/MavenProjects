package com.quiz.service;

import com.quiz.dao.*;
import com.quiz.exception.UserNotFoundException;
import com.quiz.model.User;
import com.quiz.util.Passwordgenerator;

public class UserServiceImpl implements IUserService {
	IUserDao userDao = new UserDaoImpl();

	/**
	 * This Method pass the values to dao object after generating password, will get
	 * the return value
	 * 
	 * @param user for passing user
	 * @return String auto-generated password
	 */
	@Override
	public String register(User user) {
		String password = Passwordgenerator.generatePassword(8);
		user.setPassword(password);
		return userDao.addUser(user);

	}

	/**
	 * This Method pass the values to dao object, will get the return value
	 * 
	 * @param userName for passing user name
	 * @param password for passing password
	 * @param role     for passing role
	 * @return user for passing use
	 * @throws UserNotFoundException when the user is not found
	 */
	@Override
	public User login(String userName, String password, String role) throws UserNotFoundException {
		 User user = userDao.findByUserName(userName, password, role);
		if (user==null)
			throw new UserNotFoundException("User Not Found");

		if (user.getUserName().equalsIgnoreCase(userName) && user.getPassword().equalsIgnoreCase(password) && user.getRole().equalsIgnoreCase(role))
			System.out.println("Logged In Successfully");
		return user;

	}

	/**
	 * This Method pass the values to dao object, will get the return value
	 * 
	 * @param userName for passing user name
	 * @param password for passing password
	 * @param role     for passing role
	 * @throws UserNotFoundException when the user is not found
	 */
	@Override
	public void changePassword(String userName, String password, String role) throws UserNotFoundException {
		int result = userDao.changePassword(userName, password, role);
		if (result == 0)
			throw new UserNotFoundException("User Not Found");
		else
			System.out.println("password Changed");
	}

}
