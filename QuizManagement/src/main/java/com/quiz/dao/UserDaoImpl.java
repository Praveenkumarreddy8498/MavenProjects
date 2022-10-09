package com.quiz.dao;

import java.sql.*;

import com.quiz.model.User;
import com.quiz.util.*;

/**
 * @author PraveenKumarReddy
 *
 */
public class UserDaoImpl implements IUserDao {

	/**
	 * This Method is used to add the user to Database
	 * 
	 * @param user for passing user
	 * @return String of Auto Generated Password
	 */
	@Override
	public String addUser(User user) {

		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(Queries.INSERTUSERQUERY);) {
			preparedstatement.setString(1, user.getUserName());
			preparedstatement.setString(2, user.getName());
			preparedstatement.setLong(3, user.getMobileNo());
			preparedstatement.setString(4, user.getEmail());
			preparedstatement.setString(5, user.getCity());
			preparedstatement.setString(6, user.getPassword());

			preparedstatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return user.getPassword();
	}

	/**
	 * This method is used to find the User in Database
	 * 
	 * @param userName for passing user name
	 * @param password for passing password
	 * @param role     for passing role
	 * @return User from Database
	 */
	@Override
	public User findByUserName(String userName, String password, String role) {

		ResultSet resultset = null;
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(Queries.FINDBYUSERNAME);) {

			preparedstatement.setString(1, userName);
			preparedstatement.setString(2, password);
			preparedstatement.setString(3, role);

			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				User user =new User();
				user.setUserName(resultset.getString(1));
				user.setPassword(resultset.getString(7));
				user.setRole(resultset.getString(8));
				return user;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultset != null)
					resultset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return null;
	}

	/**
	 * This Method is Used to Change the password based on parameters
	 * 
	 * @param userName for passing user name
	 * @param password for passing password
	 * @param role     for passing role
	 * @return integer from executeUpdate
	 */
	@Override
	public int changePassword(String userName, String password, String role) {

		int result = 0;
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(Queries.UPDATEPASSWORDQUERY);) {
			preparedstatement.setString(1, password);
			preparedstatement.setString(2, userName);
			preparedstatement.setString(3, role);

			result = preparedstatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}

}
