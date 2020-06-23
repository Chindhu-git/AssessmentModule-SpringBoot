package com.example.demo.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.assessment.repository.GradViewPerformanceRepository;
import com.example.demo.resource.ShowPerformance;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/login/grad")
public class GradViewPerformanceController {
	@Autowired
	GradViewPerformanceRepository gradViewPerformanceRepository;
	
	@GetMapping(path="/showperformance/{email}")
	public List<ShowPerformance> showFromDB(@PathVariable String email)
	{
		return gradViewPerformanceRepository.showFromDB(email);
	}
}
