package com.example.demo.assessment.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.resource.ProjectViewSubmission;

@Repository
public class TrainerViewProjectRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<ProjectViewSubmission> showFromDB(String project_name)
	{
		return this.jdbcTemplate.query("select * from "+project_name ,new TrainerViewProjectMapper());
	}
}
final class TrainerViewProjectMapper implements RowMapper<ProjectViewSubmission>
{
	public TrainerViewProjectMapper() {
		// TODO Auto-generated constructor stub
	}

	public ProjectViewSubmission mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		ProjectViewSubmission pvs=new ProjectViewSubmission();
		pvs.setGradEmail(rs.getString("grademail"));
		pvs.setProjectLink(rs.getString("projectlink"));
		pvs.setScore(rs.getInt("score"));
		return pvs;
	}
}
