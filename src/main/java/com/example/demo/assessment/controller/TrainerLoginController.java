package com.example.demo.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.assessment.repository.TrainerLoginRepository;
import com.example.demo.resource.TrainerLogin;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/login/trainer")
public class TrainerLoginController {
	@Autowired
	TrainerLoginRepository trainerLoginRepository;			
	
	@GetMapping()
	public String home()
	{
		return "Hey";
	}
	@PostMapping(path="/authenticate")
	public String checkTrainer(@RequestBody TrainerLogin trainerLogin)
	{
		System.out.println(trainerLogin.email);
		List<String> repocheck=trainerLoginRepository.checkTrainer(trainerLogin.email,trainerLogin.password);
		boolean repoCheck=repocheck.isEmpty();
		if(repoCheck==true)
			return "Invalid Login";
		else
			return "Authenticated";
	}
	@GetMapping(path="/trainerlist")
	public List<String> getAllTrainers()
	{
		return trainerLoginRepository.getAllTrainers();
	}
}
