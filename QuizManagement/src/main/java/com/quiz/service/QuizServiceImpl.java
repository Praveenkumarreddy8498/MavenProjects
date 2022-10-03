package com.quiz.service;

import java.sql.*;
import java.util.List;

import com.quiz.dao.IQuizDao;
import com.quiz.dao.QuizDaoImpl;
import com.quiz.exception.QuestionIdNotFoundException;
import com.quiz.model.Question;

public class QuizServiceImpl implements IQuizService {

	IQuizDao quizDao = new QuizDaoImpl();

	@Override
	public void addQuestion(Question question) {
		quizDao.addQuestion(question);

	}

	@Override
	public void updateQuestion(int questionId, String answerValue) {
		int result = quizDao.updateQuestion(questionId, answerValue);
		if (result==0)
			throw new QuestionIdNotFoundException();

	}

	@Override
	public void deleteQuestion(int questionId) {
		int result = quizDao.deleteQuestion(questionId);
		if (result==0)
			throw new QuestionIdNotFoundException();
		

	}

	@Override
	public Question getOptionsById(int questionId) {
		return quizDao.findById(questionId);

	}

	@Override
	public List<Question> getByTopic(String topic) {

		return quizDao.findByTopic(topic);
	}

	

}