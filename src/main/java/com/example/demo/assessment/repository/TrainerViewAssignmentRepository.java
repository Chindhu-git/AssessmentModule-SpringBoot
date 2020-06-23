package com.example.demo.assessment.repository;

//import java.io.File;
//import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//import org.omg.CORBA.portable.InputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.resource.ViewSubmission;

@Repository
public class TrainerViewAssignmentRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<ViewSubmission> showFromDB(String assignment_name)
	{
		return this.jdbcTemplate.query("select * from "+assignment_name ,new TrainerViewAssignmentMapper());
	}
}
final class TrainerViewAssignmentMapper implements RowMapper<ViewSubmission>
{
	public TrainerViewAssignmentMapper() {
		// TODO Auto-generated constructor stub
	}

	public ViewSubmission mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		ViewSubmission vs=new ViewSubmission();
		vs.setGradEmail(rs.getString("grademail"));
		String file_name=rs.getString("filename");
		vs.setFileName(file_name);
		//vs.setSubmittedAss(rs.getBlob("submittedass"));
		//InputStream inputStream = null;
		//FileOutputStream outputstream =null;
		try
		{
			Blob blob=rs.getBlob("submittedass");
			int blobLength = (int) blob.length();  
			
			byte byteArray[] = blob.getBytes(1, blobLength);;
			//inputStream.read(byteArray);
			/*File file=new File(file_name);
			outputstream=new FileOutputStream(file);
			outputstream.write(byteArray);
			outputstream.close();*/
			vs.setSubmittedAss(byteArray);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		vs.setScore(rs.getInt("score"));
		return vs;
	}
}