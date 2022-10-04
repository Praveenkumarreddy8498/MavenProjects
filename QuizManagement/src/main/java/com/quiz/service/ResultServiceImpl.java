package com.quiz.service;

import com.quiz.dao.IResultDao;
import com.quiz.dao.ResultDaoImpl;
import com.quiz.model.Result;

/**
 * @author PraveenKumarReddy
 *
 */
public class ResultServiceImpl implements IResultService {
	IResultDao resultDao = new ResultDaoImpl();

	/**
	 * This Method pass the values to dao object, will get the return value
	 * 
	 * @param topic
	 * @return result
	 */
	@Override
	public Result beginQuiz(String topic) {
		return resultDao.findBeginQuiz(topic);
	}

	/**
	 * This Method pass the values to dao object, will get the return value
	 * 
	 * @param correctAnswers
	 * @param totalQuestions
	 * @return integer of percentage
	 */
	@Override
	public int getPercentage(int correctAnswers, int totalQuestions) {
		return resultDao.findPercentage(correctAnswers, totalQuestions);
	}

	/**
	 * This Method pass the values to dao object, will get the return value
	 * 
	 * @param percentage
	 * @return String of grade
	 */
	@Override
	public String getPerformance(int percentage) {
		return resultDao.findPerformance(percentage);
	}

}
