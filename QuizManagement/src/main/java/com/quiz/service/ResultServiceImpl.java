package com.quiz.service;

import com.quiz.dao.IResultDao;
import com.quiz.dao.ResultDaoImpl;
import com.quiz.model.Result;

public class ResultServiceImpl implements IResultService {
	IResultDao resultDao = new ResultDaoImpl();

	@Override
	public Result beginQuiz(String topic) {
		return resultDao.findBeginQuiz(topic);
	}

	@Override
	public int getPercentage(int correctAnswers, int totalQuestions) {
		return resultDao.findPercentage(correctAnswers, totalQuestions);
	}

	@Override
	public String getPerformance(int percentage) {
		return resultDao.findPerformance(percentage);
	}

}
