package com.example.demo.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.assessment.repository.TrainerCreateProjectRepository;
import com.example.demo.resource.CreateProject;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/login/trainer/project")

public class TrainerCreateProjectController {
	@Autowired
	TrainerCreateProjectRepository trainerCreateProjectRepository;	
	
	@PostMapping(path="/create")
	public String saveToDB(@RequestBody CreateProject createProject)
	{
		return trainerCreateProjectRepository.saveToDB(createProject.email,createProject.title,createProject.description);
	}
	@GetMapping(path="/show/{email}")
	public List<CreateProject> showFromDB(@PathVariable String email)
	{
		return trainerCreateProjectRepository.showFromDB(email);
	}
}
