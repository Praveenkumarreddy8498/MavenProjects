package com.quiz.service;

import java.util.List;

import com.quiz.exception.QuestionIdNotFoundException;
import com.quiz.model.Question;

/**
 * @author PraveenKumarReddy
 *
 */
public interface IQuizService {
	void addQuestion(Question question);
	void updateQuestion(int questionId, String answerValue)throws QuestionIdNotFoundException ;
	void deleteQuestion(int questionId)throws QuestionIdNotFoundException;
	Question getOptionsById(int questionId);
	List<Question> getByTopic(String topic);
	
		
	

}
