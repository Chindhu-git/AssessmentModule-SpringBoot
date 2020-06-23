package com.example.demo.assessment.repository;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GradLoginRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<String> getAllGrads() {
		// TODO Auto-generated method stub
		
		List<String> gradList=new ArrayList<>();
		gradList.addAll(jdbcTemplate.queryForList("select email from gradlogin",String.class));
		return gradList;
	}

	public List<String> checkGrad(String new_email, String new_password) {
		// TODO Auto-generated method stub
		List<String> gradList=new ArrayList<>();
		System.out.println("select email from gradlogin where email='"+new_email+"' and password='"+new_password+"'");
		gradList.addAll(jdbcTemplate.queryForList("select email from gradlogin where email='"+new_email+"' and password='"+new_password+"'",String.class));
		return gradList;
	}

}
