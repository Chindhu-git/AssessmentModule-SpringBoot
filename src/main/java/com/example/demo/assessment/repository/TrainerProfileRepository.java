package com.example.demo.assessment.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TrainerProfileRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public String getTrainerProfile(String new_email) {
		String profileList="";
		System.out.println("select name from trainerprofile where email='"+new_email+"'");
		profileList=jdbcTemplate.queryForList("select id from trainerprofile where email='"+new_email+"'",String.class)+",";
		profileList=profileList+jdbcTemplate.queryForList("select name from trainerprofile where email='"+new_email+"'",String.class)+",";
		profileList=profileList+jdbcTemplate.queryForList("select team from trainerprofile where email='"+new_email+"'",String.class)+",";
		System.out.println(profileList);
		return profileList;
	}
}
