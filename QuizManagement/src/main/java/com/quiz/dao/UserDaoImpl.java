package com.quiz.dao;

import java.sql.*;

import com.quiz.model.User;
import com.quiz.util.*;

public class UserDaoImpl implements IUserDao {

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

	@Override
	public User findByUserName(String userName, String password, String role) {

		ResultSet resultset = null;
		User user = new User();
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(Queries.FINDBYUSERNAME);) {

			preparedstatement.setString(1, userName);
			preparedstatement.setString(2, password);
			preparedstatement.setString(3, role);

			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				user.setUserName(resultset.getString(1));
				user.setPassword(resultset.getString(7));
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

		return user;
	}

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
