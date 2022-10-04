package com.quiz.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import com.quiz.model.Answer;
import com.quiz.model.Question;

/**
 * @author PraveenKumarReddy
 *
 */
public class QuestionMapper implements IRowMapper {

	/**
	 * This method maps the rows of result set
	 * 
	 * @param resultset
	 * @return list of questions
	 * @throws SQLException
	 */
	@Override
	public List<Question> mapRow(ResultSet resultset) throws SQLException {
		List<Question> questionList = new ArrayList<>();
		while (resultset.next()) {
			Question question = new Question();
			Answer answer = new Answer();
			question.setQuestionId(resultset.getInt(1));
			question.setQuestion(resultset.getString(2));
			question.setOptionOne(resultset.getString(3));
			question.setOptionTwo(resultset.getString(4));
			question.setOptionThree(resultset.getString(5));
			question.setOptionFour(resultset.getString(6));
			answer.setAnswerId(resultset.getInt(7));
			answer.setAnswerValue(resultset.getString(8));
			question.setAnswer(answer);
			questionList.add(question);
		}
		return questionList;

	}

}
