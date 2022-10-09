package com.quiz.util;

import java.sql.SQLException;
import java.util.List;

import java.sql.ResultSet;
import com.quiz.model.Question;

/**
 * @author PraveenKumarReddy
 *
 */
public interface IRowMapper {
	/**
	 * This method maps the rows of result set
	 * 
	 * @param resultset for passing resultset values
	 * @return list of questions
	 * @throws SQLException for Exception
	 */
	List<Question> mapRow(ResultSet resultset) throws SQLException;

}
