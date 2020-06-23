package com.example.demo.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.assessment.repository.TrainerEvaluateProjectRepository;
import com.example.demo.resource.EvaluateProject;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/login/trainer/project")

public class TrainerEvaluateProjectController {
	@Autowired
	TrainerEvaluateProjectRepository trainerEvaluateProjectRepository;
	
	@PostMapping(path="/evaluate")
	public String evaluateSubmission(@RequestBody EvaluateProject evaluateProject)
	{
		return trainerEvaluateProjectRepository.evaluateSubmission(evaluateProject.project_name,evaluateProject.grademail,evaluateProject.score);
	}
}
