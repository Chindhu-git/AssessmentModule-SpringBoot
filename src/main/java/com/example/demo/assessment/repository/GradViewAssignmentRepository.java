package com.example.demo.assessment.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.resource.ViewAssignment;

@Repository
public class GradViewAssignmentRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<ViewAssignment> showFromDB()
	{
		return this.jdbcTemplate.query("select * from createassignment",new GradAssignmentMapper());
	}
}
final class GradAssignmentMapper implements RowMapper<ViewAssignment>
{
	public GradAssignmentMapper() {
		// TODO Auto-generated constructor stub
	}

	public ViewAssignment mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		ViewAssignment va=new ViewAssignment();
		va.setEmail(rs.getString("email"));
		va.setTitle(rs.getString("title"));
		va.setDescription(rs.getString("description"));
		return va;
	}
}