package com.example.demo.assessment.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class TrainerEvaluateAssignmentRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	public String evaluateSubmission(String assignment_name,String grademail,int score)
	{
		int nest_check=0,temp_return_value=0;
		nest_check=jdbcTemplate.queryForObject("select exists(select title from overall_performance where title='"+assignment_name+"' and grademail='"+grademail+"')", Integer.class);
		if(nest_check>0)
		{
			temp_return_value=jdbcTemplate.update("update overall_performance set score="+score+" where title='"+assignment_name+"' and grademail='"+grademail+"'");
		}
		else
		{
			temp_return_value=jdbcTemplate.update("insert into overall_performance values('"+grademail+"','"+assignment_name+"','assignment',"+score+")");
		}
		int return_value=jdbcTemplate.update("update "+assignment_name+" set score="+score+" where grademail='"+grademail+"'");
		if((return_value>0)&&(temp_return_value>0))
		{
			return "Score updated";
		}
		else
		{
			return "Unable to update Score";
		}
	}
}
