package com.quiz.dao;

import com.quiz.model.User;

/**
 * @author PraveenKumarReddy
 *
 */
public interface IUserDao {
	String addUser(User user);
	User findByUserName(String userName,String password,String role);
	int changePassword(String userName,String password,String role);

}
