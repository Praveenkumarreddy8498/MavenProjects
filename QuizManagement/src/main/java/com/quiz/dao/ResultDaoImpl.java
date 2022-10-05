package com.quiz.dao;

import java.util.List;
import java.util.Scanner;

import com.quiz.model.Question;
import com.quiz.model.Result;

/**
 * @author PraveenKumarReddy
 *
 */
public class ResultDaoImpl implements IResultDao {
	IQuizDao quizDao = new QuizDaoImpl();
	
	/**
	 * This method does the quiz operation
	 * @param topic for finding the topic
	 * @return Result
	 */
	@Override
	public Result findBeginQuiz(String topic) {
		List<Question> questionList = quizDao.findByTopic(topic);
		int countTotal = 0;
		int countRight = 0;
		int countWrong = 0;
		for (Question question : questionList) {
			int num = 1;
			System.out.println("Question " + num + " " + question.getQuestion());
			System.out.println("1 : " + question.getOptionOne());
			System.out.println("2 : " + question.getOptionTwo());
			System.out.println("3 : " + question.getOptionThree());
			System.out.println("4 : " + question.getOptionFour());
			String answer = "";
			int ans;
			System.out.println("Enter Your Answer");
			Scanner sc = new Scanner(System.in);
			ans = sc.nextInt();
			sc.nextLine();
			switch (ans) {
			case 1:
				answer = question.getOptionOne();
				break;
			case 2:
				answer = question.getOptionTwo();
				break;
			case 3:
				answer = question.getOptionThree();
				break;
			case 4:
				answer = question.getOptionFour();
				break;
			default:
				break;
			}
			System.out
					.println("Your answer " + answer + " ,Original Answer is " + question.getAnswer().getAnswerValue());
			if (answer.equals(question.getAnswer().getAnswerValue())) {
				System.out.println("\nIt's Correct Answer");
				countRight++;
			} else {
				System.out.println("\nSorry It's Wrong Answer");
				countWrong++;
			}
			countTotal++;
			num += 1;

		}
		// Result result = new Result(countTotal, countRight, countWrong);
		Result result = new Result();
		result.setTotalQuestions(countTotal);
		result.setCorrectAnswers(countRight);
		result.setWrongAnswers(countWrong);
		return result;
	}

	/**
	 * This method is used for finding the percentage of the result
	 * @param  correctAnswers for passing Correct Answers
	 * @param totalQuestions for passing Total Questions
	 * @return integer value of percentage
	 */
	@Override
	public int findPercentage(int correctAnswers, int totalQuestions) {

		return (correctAnswers / totalQuestions) * 100;
	}

	/**
	 * This method is used for giving the grades based on percentage
	 * @param percentage for passing percentage 
	 * @return String of grade
	 */
	@Override
	public String findPerformance(int percentage) {
		String grade = "";

		if (percentage >= 80) {
			grade = "A";
		} else if (percentage < 80 && percentage > 60) {
			grade = "B";
		} else if (percentage < 40) {
			grade = "C";
		}

		return grade;
	}

}
