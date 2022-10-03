package com.quiz.main;

import java.util.Scanner;

import com.quiz.model.Result;
import com.quiz.model.Topic;
import com.quiz.service.IResultService;
import com.quiz.service.ResultServiceImpl;

public class Checker {

	public static void main(String[] args) {
		IResultService resultService = new ResultServiceImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("To begin Quiz");
		System.out.println("Enter Topic\n" + "0.JAVA\n" + "1.HTML\n" + "2.General Knowledge\n");
		int choose = sc.nextInt();
		sc.nextLine();
		String topic = Topic.values()[choose].topic;
		 resultService.beginQuiz(topic);

		/*System.out.println("Your results!");
		System.out.println("Total Questions " + result.getTotalQuestions());
		System.out.println("Number of correct answers " + result.getCorrectAnswers());
		System.out.println("Number of wrong answers " + result.getWrongAnswers());
		System.out.println(
				"Percentage " + resultService.getPercentage(result.getCorrectAnswers(), result.getTotalQuestions()));
		System.out.println("Your performance " + resultService
				.getPerformance(resultService.getPercentage(result.getCorrectAnswers(), result.getTotalQuestions())));*/
	}

}
