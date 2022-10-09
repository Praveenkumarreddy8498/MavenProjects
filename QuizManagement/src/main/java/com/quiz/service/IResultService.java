package com.quiz.service;

import com.quiz.model.Result;

/**
 * @author PraveenKumarReddy
 *
 */
public interface IResultService {
	/**
	 * This Method pass the values to dao object, will get the return value
	 * 
	 * @param topic for passing topic
	 * @return result
	 */
	Result beginQuiz(String topic);

	/**
	 * This Method pass the values to dao object, will get the return value
	 * 
	 * @param correctAnswers for passing correct answers
	 * @param totalQuestions for passing total questions
	 * @return integer of percentage
	 */
	int getPercentage(int correctAnswers, int totalQuestions);

	/**
	 * This Method pass the values to dao object, will get the return value
	 * 
	 * @param percentage for passing percentage
	 * @return String of grade
	 */
	String getPerformance(int percentage);

}
