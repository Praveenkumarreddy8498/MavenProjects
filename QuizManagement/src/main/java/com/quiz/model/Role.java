package com.quiz.model;

/**
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
