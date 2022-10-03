package com.quiz.exception;

public class QuestionIdNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QuestionIdNotFoundException() {
		super();
	}

	public QuestionIdNotFoundException(String message) {
		super(message);
	}
	

}
