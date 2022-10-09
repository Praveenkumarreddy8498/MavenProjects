package com.quiz.model;

/**
 * This is Enum of Topic
 * @author PraveenKumarReddy
 *
 */
public enum Topic {
	JAVA("JAVA"), HTML("HTML"), GK("General Knowledge");

	public String topic;

	private Topic(String topic) {
		this.topic = topic;
	}

}
