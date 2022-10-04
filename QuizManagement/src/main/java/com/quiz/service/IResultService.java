package com.quiz.service;

import com.quiz.model.Result;

/**
 * @author PraveenKumarReddy
 *
 */
public interface IResultService {
	Result beginQuiz(String topic);
    int getPercentage(int correctAnswers,int totalQuestions);
    String getPerformance(int percentage);

}
