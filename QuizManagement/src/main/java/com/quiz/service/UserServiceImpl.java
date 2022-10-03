package com.quiz.service;

import com.quiz.dao.*;
import com.quiz.exception.UserNotFoundException;
import com.quiz.model.User;
import com.quiz.util.Passwordgenerator;

public class UserServiceImpl implements IUserService {
	IUserDao userDao = new UserDaoImpl();

	@Override
	public String register(User user) {
		String password = Passwordgenerator.generatePassword(8);
		user.setPassword(password);
		return userDao.addUser(user);

	}

	@Override
	public User login(String userName, String password,String role) throws UserNotFoundException{

		User user = userDao.findByUserName(userName, password,role);
		if (user.getUserName()==null)
			throw new UserNotFoundException("User Not Found");

		else
			if(user.getUserName().equals(userName)&&user.getPassword().equals(password));
			System.out.println("Logged In Successfully");
			return user;

	}

	@Override
	public void changePassword(String userName, String password,String role) throws UserNotFoundException{
		int result = userDao.changePassword(userName, password,role);
		if (result == 0)
			throw new UserNotFoundException("User Not Found");
		else
			System.out.println("password Changed");
	}

}
