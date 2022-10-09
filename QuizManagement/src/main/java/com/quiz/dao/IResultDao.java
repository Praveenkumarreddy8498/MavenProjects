package com.quiz.dao;

import com.quiz.model.Result;

/**
 * @author PraveenKumarReddy
 *
 */
public interface IResultDao {
	/**
	 * This method does the quiz operation
	 * 
	 * @param topic for finding the topic
	 * @return Result
	 */
	Result findBeginQuiz(String topic);

	/**
	 * This method is used for finding the percentage of the result
	 * 
	 * @param correctAnswers for passing Correct Answers
	 * @param totalQuestions for passing Total Questions
	 * @return integer value of percentage
	 */
	int findPercentage(int correctAnswers, int totalQuestions);

	/**
	 * This method is used for giving the grades based on percentage
	 * 
	 * @param percentage for passing percentage
	 * @return String of grade
	 */
	String findPerformance(int percentage);

}
