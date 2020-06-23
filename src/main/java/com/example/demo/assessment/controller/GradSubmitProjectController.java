package com.example.demo.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.assessment.repository.GradSubmitProjectRepository;
import com.example.demo.resource.SubmittedProject;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/login/grad/project")
public class GradSubmitProjectController {
	@Autowired
	GradSubmitProjectRepository gradSubmitProjectRepository;
	
	@PostMapping(path="/submit")
	public String uploadassignment(@RequestBody SubmittedProject submittedProject)
	{
		return gradSubmitProjectRepository.uploadproject(submittedProject.project_name,submittedProject.email,submittedProject.projectlink);
	}
}
