package com.quiz.service;

import com.quiz.exception.UserNotFoundException;
import com.quiz.model.User;

public interface IUserService {
	String register(User user);

	User login(String userName, String password, String role) throws UserNotFoundException;

	void changePassword(String userName, String password, String role) throws UserNotFoundException;

}
