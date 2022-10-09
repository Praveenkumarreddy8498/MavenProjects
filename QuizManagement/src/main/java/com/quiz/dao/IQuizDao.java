package com.quiz.dao;

import java.util.List;


import com.quiz.model.Question;

/**
 * @author PraveenKumarReddy
 *
 */
public interface IQuizDao {
	/*
	 * This method adds the question into database
	 * 
	 * @param question
	 * 
	 */
	void addQuestion(Question question);

	/*
	 * This method updates the answer value based on question no in database
	 * 
	 * @param questionNo for finding the question
	 * 
	 * @param answerValue for setting the answer value
	 * 
	 * @return integer value from executeUpdate method
	 */
	int updateQuestion(int questionId, String answerValue);

	/**
	 * This method returns the question based on question id from database
	 * 
	 * @param questionId for finding the question
	 * 
	 * @return question based on question id
	 */
	int deleteQuestion(int questionId);

	/**
	 * This method delete the question in database based on question id given
	 * 
	 * @param questionId for finding the question
	 * 
	 * @return integer value from executeUpdate method
	 */

	Question findById(int questionId);

	/**
	 * This method finds the Questions from database based on topic given
	 * 
	 * @param topic for finding the topic
	 * 
	 * @return list of questions
	 */

	List<Question> findByTopic(String topic);

}
