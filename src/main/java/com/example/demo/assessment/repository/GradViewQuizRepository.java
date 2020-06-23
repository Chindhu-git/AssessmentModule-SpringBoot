package com.example.demo.assessment.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.resource.ViewQuiz;

@Repository
public class GradViewQuizRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<ViewQuiz> showFromDB()
	{
		return this.jdbcTemplate.query("select * from createquiz",new GradQuizMapper());
	}
}
final class GradQuizMapper implements RowMapper<ViewQuiz>
{
	public GradQuizMapper() {
		// TODO Auto-generated constructor stub
	}

	public ViewQuiz mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		ViewQuiz vq=new ViewQuiz();
		vq.setEmail(rs.getString("email"));
		vq.setTitle(rs.getString("title"));
		return vq;
	}
}

