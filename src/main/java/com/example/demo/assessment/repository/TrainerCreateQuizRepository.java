package com.example.demo.assessment.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.resource.CreateQuiz;

@Repository
public class TrainerCreateQuizRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	public String saveToDB(String email, String title) {
		int return_value=jdbcTemplate.update("insert into createquiz values('"+email+"','"+title+"')");
		if(return_value>0)
		{
			jdbcTemplate.execute("create table "+title+" ( grademail varchar(255), score int)");
			return "Saved Successfully";
		}
		else
		{
			return "Unable to create";
		}
	}
	public List<CreateQuiz> showFromDB(String email)
	{
		return this.jdbcTemplate.query("select * from createquiz where email='"+email+"'",new QuizMapper());
	}
	public String addQue(String quiz_name, String que, String opta, String optb, String optc, String optd, String ans) {
		int return_value=jdbcTemplate.update("insert into addque values('"+que+"','"+quiz_name+"','"+opta+"','"+optb+"','"+optc+"','"+optd+"','"+ans+"')");
		if(return_value>0)
		{
			return "Uploaded Successfully";
		}
		else
		{
			return "Unable to insert";
		}
	}
}
final class QuizMapper implements RowMapper<CreateQuiz>
{
	public QuizMapper() {
		// TODO Auto-generated constructor stub
	}

	public CreateQuiz mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		CreateQuiz cq=new CreateQuiz();
		cq.setEmail(rs.getString("email"));
		cq.setTitle(rs.getString("title"));
		return cq;
	}
}