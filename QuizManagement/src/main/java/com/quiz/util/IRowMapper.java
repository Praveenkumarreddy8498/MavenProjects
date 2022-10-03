package com.quiz.util;

import java.sql.SQLException;
import java.util.List;

import java.sql.ResultSet;
import com.quiz.model.Question;

public interface IRowMapper {
	List<Question> mapRow(ResultSet resultset)throws SQLException;
	

}
