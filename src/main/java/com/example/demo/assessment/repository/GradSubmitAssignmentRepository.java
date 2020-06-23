package com.example.demo.assessment.repository;

//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
//import java.io.IOException;
/*import java.sql.Blob;*/
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;

//import org.omg.CORBA.portable.InputStream;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Cache.Connection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GradSubmitAssignmentRepository{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public String uploadassignment(String assignment_name,String email,String filename, /*String filepath*/File uploadfile) throws Exception{
		// TODO Auto-generated method stub
		int return_value=0;
		int check=jdbcTemplate.queryForObject("select exists(select grademail from "+assignment_name+" where grademail='"+email+"' )", Integer.class);
		if(check>0)
		{
			int nest_check=jdbcTemplate.queryForObject("select exists(select grademail from "+assignment_name+" where grademail='"+email+"' and score=-1)", Integer.class);
			if(nest_check>0)
			{
				int temp_return_value=jdbcTemplate.update("delete from "+assignment_name+" where grademail='"+email+"'");
				System.out.println(temp_return_value);
			}
		}
		FileInputStream fis=null;
		Connection conn=null;
		String url = "jdbc:mysql://localhost:3306/spring_angular";
        String user = "springuser";
        String password = "springuser";
		try
		{
			File f=new File("/home/chindhu/road damage detection/docs/thesis/"/*filepath*/+filename);
			fis=new FileInputStream(f);
			conn = DriverManager.getConnection(url, user, password);
			String sql= "insert into "+assignment_name+" values (?,?,?,-1)";
			PreparedStatement statement = ((java.sql.Connection) conn).prepareStatement(sql);
			//statement.setString(1, assignment_name);
			statement.setString(1, email);
			statement.setString(2, filename);
			statement.setBinaryStream(3, fis);
			return_value=statement.executeUpdate();
			System.out.println(return_value);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			fis.close();
			//conn.close();
		}
		//return_value=jdbcTemplate.update("insert into "+assignment_name+" values('"+new_email+"','"+new_filename+"','"+new_uploadedfile+"',-1)");
		
		if(return_value>0)
		{
			return "Upload Successfull";
		}
		else
			return "Failed to upload";

	}
}
