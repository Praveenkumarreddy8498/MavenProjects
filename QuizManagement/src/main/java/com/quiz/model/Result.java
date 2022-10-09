package com.quiz.model;

/**
 * This Class is java bean of Result
 * 
 * @author PraveenKumarReddy
 *
 */
public class Result {
	private int totalQuestions;
	private int correctAnswers;
	private int wrongAnswers;

	public Result() {
		super();
	}

	public Result(int totalQuestions, int correctAnswers, int wrongAnswers) {
		this.totalQuestions = totalQuestions;
		this.correctAnswers = correctAnswers;
		this.wrongAnswers = wrongAnswers;
	}

	public int getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}

	public int getCorrectAnswers() {
		return correctAnswers;
	}

	public void setCorrectAnswers(int correctAnswers) {
		this.correctAnswers = correctAnswers;
	}

	public int getWrongAnswers() {
		return wrongAnswers;
	}

	public void setWrongAnswers(int wrongAnswers) {
		this.wrongAnswers = wrongAnswers;
	}

}
