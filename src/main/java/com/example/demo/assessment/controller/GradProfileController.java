package com.example.demo.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.assessment.repository.GradProfileRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/login/grad/profile")
public class GradProfileController {
	
	@Autowired
	GradProfileRepository gradProfileRepository;	
	
	@GetMapping()
	public String home()
	{
		return "Hey profile";
	}
	
	@PostMapping(path="/profilelist")
	public String getGradProfile(@RequestBody String email)
	{
		String repocheck=gradProfileRepository.getGradProfile(email);
		return repocheck;
	}
}
