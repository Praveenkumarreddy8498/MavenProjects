package com.quiz.service;

import com.quiz.model.Result;

public interface IResultService {
	Result beginQuiz(String topic);
    int getPercentage(int correctAnswers,int totalQuestions);
    String getPerformance(int percentage);

}
