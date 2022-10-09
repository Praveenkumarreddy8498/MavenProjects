package com.quiz.model;

/**
 * This is Enum of Role
 * @author PraveenKumarReddy
 *
 */
public enum Role {
	ADMIN("Admin"), USER("User");

	public String role;

	private Role(String role) {
		this.role = role;
	}

}
