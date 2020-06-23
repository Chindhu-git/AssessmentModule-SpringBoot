package com.example.demo.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.assessment.repository.TrainerViewProjectRepository;
import com.example.demo.resource.ProjectViewSubmission;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/login/trainer/project")

public class TrainerViewProjectController {
	@Autowired
	TrainerViewProjectRepository trainerViewProjectRepository;
	
	@GetMapping(path="/view/{project_name}")
	public List<ProjectViewSubmission> showFromDB(@PathVariable String project_name)
	{
		System.out.println(project_name);
		return trainerViewProjectRepository.showFromDB(project_name);
	}
}
