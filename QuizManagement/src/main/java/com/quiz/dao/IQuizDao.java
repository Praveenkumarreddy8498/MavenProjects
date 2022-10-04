package com.quiz.dao;

import java.util.List;

import com.quiz.model.Question;
import com.quiz.model.Result;

/**
 * @author PraveenKumarReddy
 *
 */
public interface IQuizDao {
	void addQuestion(Question question);
	int updateQuestion(int questionId, String answerValue);
	int deleteQuestion(int questionId);
	Question findById(int questionId);
	List<Question> findByTopic(String topic);

}
