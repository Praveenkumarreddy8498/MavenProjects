package com.quiz.service;

import java.util.List;

import com.quiz.dao.IQuizDao;
import com.quiz.dao.QuizDaoImpl;
import com.quiz.exception.QuestionIdNotFoundException;
import com.quiz.model.Question;

/**
 * @author PraveenKumarReddy
 *
 */
public class QuizServiceImpl implements IQuizService {

	IQuizDao quizDao = new QuizDaoImpl();

	/*
	 * This method adds the question into dao object
	 * 
	 * @param question
	 * 
	 */
	@Override
	public void addQuestion(Question question) {
		quizDao.addQuestion(question);

	}

	/**
	 * This method pass the values to dao object and get the return value
	 * 
	 * @param questionId  for passing question id
	 * @param answerValue for passing answer value
	 * @throws QuestionIdNotFoundException when the question is not found
	 */
	@Override
	public void updateQuestion(int questionId, String answerValue) throws QuestionIdNotFoundException {
		int result = quizDao.updateQuestion(questionId, answerValue);
		if (result == 0)
			throw new QuestionIdNotFoundException();

	}

	/**
	 * This method pass the values to dao object,will get the return value
	 * 
	 * @param questionId for passing question id
	 * @throws QuestionIdNotFoundException when the question is not found
	 */
	@Override
	public void deleteQuestion(int questionId) throws QuestionIdNotFoundException {
		int result = quizDao.deleteQuestion(questionId);
		if (result == 0)
			throw new QuestionIdNotFoundException();

	}

	/**
	 * This Method pass the values to dao object, will get the return value
	 * 
	 * @param questionId for passing question id
	 * @return question
	 */
	@Override
	public Question getOptionsById(int questionId) {
		return quizDao.findById(questionId);

	}

	/**
	 * This Method pass the values to dao object, will get the return value
	 * 
	 * @param topic for passing topic
	 * @return list of questions
	 */
	@Override
	public List<Question> getByTopic(String topic) {

		return quizDao.findByTopic(topic);
	}

}