package com.example.demo.assessment.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.resource.ViewProject;

@Repository
public class GradViewProjectRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<ViewProject> showFromDB()
	{
		return this.jdbcTemplate.query("select * from createproject",new GradProjectMapper());
	}
	final class GradProjectMapper implements RowMapper<ViewProject>
	{
		public GradProjectMapper() {
			// TODO Auto-generated constructor stub
		}

		public ViewProject mapRow(ResultSet rs, int rowNum) throws SQLException
		{
			ViewProject vp=new ViewProject();
			vp.setEmail(rs.getString("email"));
			vp.setTitle(rs.getString("title"));
			vp.setDescription(rs.getString("description"));
			return vp;
		}
	}
}
