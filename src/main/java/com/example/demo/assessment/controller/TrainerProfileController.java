package com.example.demo.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.assessment.repository.TrainerProfileRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/login/trainer/profile")
public class TrainerProfileController {
	@Autowired
	TrainerProfileRepository trainerProfileRepository;	
	
	@GetMapping()
	public String home()
	{
		return "Hey profile";
	}
	
	@PostMapping(path="/profilelist")
	public String getTrainerProfile(@RequestBody String email)
	{
		String repocheck=trainerProfileRepository.getTrainerProfile(email);
		return repocheck;
	}
}
