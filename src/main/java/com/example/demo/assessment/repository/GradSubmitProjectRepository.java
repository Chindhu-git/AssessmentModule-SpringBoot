package com.example.demo.assessment.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class GradSubmitProjectRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public String uploadproject(String project_name,String email,String projectlink)
	{
		int return_value=0;
		int check=jdbcTemplate.queryForObject("select exists(select grademail from "+project_name+" where grademail='"+email+"' )", Integer.class);
		if(check>0)
		{
			int nest_check=jdbcTemplate.queryForObject("select exists(select grademail from "+project_name+" where grademail='"+email+"' and score=-1)", Integer.class);
			if(nest_check>0)
			{
				int temp_return_value=jdbcTemplate.update("delete from "+project_name+" where grademail='"+email+"'");
				System.out.println(temp_return_value);
			}
		}
		return_value=jdbcTemplate.update("insert into "+project_name+" values('"+email+"','"+projectlink+"',-1)");
		if(return_value>0)
		{
			return "Upload Successfull";
		}
		else
		{
			return "Failed to upload";
		}
	}
}
