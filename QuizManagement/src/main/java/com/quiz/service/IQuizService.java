package com.quiz.service;

import java.util.List;

import com.quiz.exception.QuestionIdNotFoundException;
import com.quiz.model.Question;

/**
 * @author PraveenKumarReddy
 *
 */
public interface IQuizService {
	/*
	 * This method adds the question into dao object
	 * 
	 * @param question
	 * 
	 */
	void addQuestion(Question question);
	
	/**
	 * This method pass the values to dao object and get the return value
	 * 
	 * @param questionId for passing question id
	 * @param answerValue for passing answer value
	 * @throws QuestionIdNotFoundException when the question is not found
	 */
	void updateQuestion(int questionId, String answerValue) throws QuestionIdNotFoundException;
	/**
	 * This method pass the values to dao object,will get the return value
	 * 
	 * @param questionId for passing question id
	 * @throws QuestionIdNotFoundException when the question is not found
	 */
	void deleteQuestion(int questionId) throws QuestionIdNotFoundException;
	/**
	 * This Method pass the values to dao object, will get the return value
	 * 
	 * @param questionId for passing question id
	 * @return question
	 */
	Question getOptionsById(int questionId);

	/**
	 * This Method pass the values to dao object, will get the return value
	 * 
	 * @param topic for passing topic
	 * @return list of questions
	 */
	List<Question> getByTopic(String topic);

}
