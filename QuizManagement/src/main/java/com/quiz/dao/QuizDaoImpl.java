package com.quiz.dao;

import java.sql.*;
import java.util.*;

import com.quiz.model.*;
import com.quiz.util.*;

public class QuizDaoImpl implements IQuizDao {
	/*
	 * This method adds the question into database
	 * 
	 * @param question
	 * 
	 */
	@Override
	public void addQuestion(Question question) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		try {
			connection = DbConnection.openConnection();
			preparedstatement = connection.prepareStatement(Queries.INSERTANSWERQUERY);
			preparedstatement.setInt(1, question.getAnswer().getAnswerId());
			preparedstatement.setString(2, question.getAnswer().getAnswerValue());
			preparedstatement.execute();
			preparedstatement.close();

			preparedstatement = connection.prepareStatement(Queries.INSERTQUESTIONQUERY);
			preparedstatement.setInt(1, question.getQuestionId());
			preparedstatement.setString(2, question.getTopic());
			preparedstatement.setString(3, question.getQuestion());
			preparedstatement.setString(4, question.getOptionOne());
			preparedstatement.setString(5, question.getOptionTwo());
			preparedstatement.setString(6, question.getOptionThree());
			preparedstatement.setString(7, question.getOptionFour());
			preparedstatement.setInt(8, question.getAnswer().getAnswerId());
			preparedstatement.execute();
			preparedstatement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection();
			try {
				if (preparedstatement != null)
					preparedstatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}
	/*
	 * This method updates the answer value based on question no in database
	 * 
	 * @param questionNo for finding the question
	 * 
	 * @param answerValue for setting the answer value
	 * 
	 * @return integer value from executeUpdate method
	 */

	@Override
	public int updateQuestion(int questionNo, String answerValue) {

		int result = 0;
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(Queries.UPDATEANSWERQUERY);) {

			preparedstatement.setString(1, answerValue);
			preparedstatement.setInt(2, questionNo);
			result = preparedstatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

	/**
	 * This method returns the question based on question id from database
	 * 
	 * @param questionId for finding the question
	 * 
	 * @return question based on question id
	 */
	@Override
	public Question findById(int questionId) {

		ResultSet resultset = null;
		Question question = new Question();
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(Queries.FINDOPTIONSBYQUESTIONID);) {
			preparedstatement.setInt(1, questionId);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				question.setQuestion(resultset.getString(1));
				question.setOptionOne(resultset.getString(2));
				question.setOptionTwo(resultset.getString(3));
				question.setOptionThree(resultset.getString(4));
				question.setOptionFour(resultset.getString(5));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (resultset != null)
					resultset.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return question;

	}

	/**
	 * This method delete the question in database based on question id given
	 * 
	 * @param questionId for finding the question
	 * 
	 * @return integer value from executeUpdate method
	 */
	@Override
	public int deleteQuestion(int questionId) {
		int result = 0;
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(Queries.DELETEBYQUESTIONID);) {

			preparedstatement.setInt(1, questionId);
			result = preparedstatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return result;

	}

	/**
	 * This method finds the Questions from database based on topic given
	 * 
	 * @param topic for finding the topic
	 * 
	 * @return list of questions
	 */
	@Override
	public List<Question> findByTopic(String topic) {
		List<Question> questionList = new ArrayList<>();

		ResultSet resultset = null;
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(Queries.FINDBYTOPICQUERY);) {
			preparedstatement.setString(1, topic);
			resultset = preparedstatement.executeQuery();

			IRowMapper mapper = new QuestionMapper();
			questionList = mapper.mapRow(resultset);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection();
			try {
				if (resultset != null)
					resultset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return questionList;
	}

}
