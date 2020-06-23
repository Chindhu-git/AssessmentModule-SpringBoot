package com.example.demo.assessment.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GradProfileRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public String getGradProfile(String new_email) {
		String profileList="";
		System.out.println("select name from gradprofile where email='"+new_email+"'");
		profileList=jdbcTemplate.queryForList("select id from gradprofile where email='"+new_email+"'",String.class)+",";
		profileList=profileList+jdbcTemplate.queryForList("select name from gradprofile where email='"+new_email+"'",String.class)+",";
		profileList=profileList+jdbcTemplate.queryForList("select course from gradprofile where email='"+new_email+"'",String.class)+",";
		profileList=profileList+jdbcTemplate.queryForList("select frontendmentor from gradprofile where email='"+new_email+"'",String.class)+",";
		profileList=profileList+jdbcTemplate.queryForList("select backendmentor from gradprofile where email='"+new_email+"'",String.class)+",";
		System.out.println(profileList);
		return profileList;
	}																																																																																																																																															
}
