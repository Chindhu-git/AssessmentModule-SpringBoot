package com.example.demo.assessment.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.resource.CreateAssignment;

@Repository
public class TrainerCreateAssignmentRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	public String saveToDB(String new_email, String new_title,String new_desc) {
		// TODO Auto-generated method stub
		System.out.println("insert into createassignment values('"+new_email+"','"+new_title+"','"+new_desc+"')");
		int return_value=jdbcTemplate.update("insert into createassignment values('"+new_email+"','"+new_title+"','"+new_desc+"')");
		if(return_value>0)
		{
			jdbcTemplate.execute("create table "+new_title+" ( grademail varchar(255),filename varchar(255), submittedass mediumblob, score int)");
			return "Saved Successfully";
		}
		else
		{
			return "Unable to create";
		}
	}
	public List<CreateAssignment> showFromDB(String new_email)
	{
		return this.jdbcTemplate.query("select * from createassignment where email='"+new_email+"'",new AssignmentMapper());
	}
}
final class AssignmentMapper implements RowMapper<CreateAssignment>
{
	public AssignmentMapper() {
		// TODO Auto-generated constructor stub
	}

	public CreateAssignment mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		CreateAssignment ca=new CreateAssignment();
		ca.setEmail(rs.getString("email"));
		ca.setTitle(rs.getString("title"));
		ca.setDescription(rs.getString("description"));
		System.out.println("ref="+ca.email+" "+ca.title+" "+ca.description);
		return ca;
	}
}