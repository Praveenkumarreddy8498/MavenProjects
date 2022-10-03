package com.quiz.dao;

import com.quiz.model.Result;

public interface IResultDao {
	Result findBeginQuiz(String topic);
    int findPercentage(int correctAnswers,int totalQuestions);
    String findPerformance(int percentage);

}
