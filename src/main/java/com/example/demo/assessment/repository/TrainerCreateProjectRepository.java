package com.example.demo.assessment.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.resource.CreateProject;

@Repository
public class TrainerCreateProjectRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public String saveToDB(String new_email, String new_title,String new_desc) {
		// TODO Auto-generated method stub
		
		int return_value=jdbcTemplate.update("insert into createproject values('"+new_email+"','"+new_title+"','"+new_desc+"')");
		if(return_value>0)
		{
			jdbcTemplate.execute("create table "+new_title+" ( grademail varchar(255), projectlink varchar(255), score int)");
			return "Saved Successfully";
		}
		else
		{
			return "Unable to create";
		}
	}
	
	public List<CreateProject> showFromDB(String new_email)
	{
		return this.jdbcTemplate.query("select * from createproject where email='"+new_email+"'",new ProjectMapper());
	}
}
final class ProjectMapper implements RowMapper<CreateProject>
{
	public ProjectMapper() {
		// TODO Auto-generated constructor stub
	}

	public CreateProject mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		CreateProject cp=new CreateProject();
		cp.setEmail(rs.getString("email"));
		cp.setTitle(rs.getString("title"));
		cp.setDescription(rs.getString("description"));
		System.out.println("ref="+cp.email+" "+cp.title+" "+cp.description);
		return cp;
	}
}
