package com.example.demo.assessment.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TrainerLoginRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<String> getAllTrainers() {
		// TODO Auto-generated method stub
		
		List<String> trainerList=new ArrayList<>();
		trainerList.addAll(jdbcTemplate.queryForList("select email from trainerlogin",String.class));
		return trainerList;
	}

	public List<String> checkTrainer(String new_email, String new_password) {
		// TODO Auto-generated method stub
		List<String> trainerList=new ArrayList<>();
		System.out.println("select email from trainerlogin where email='"+new_email+"' and password='"+new_password+"'");
		trainerList.addAll(jdbcTemplate.queryForList("select email from trainerlogin where email='"+new_email+"' and password='"+new_password+"'",String.class));
		return trainerList;
	}
}
