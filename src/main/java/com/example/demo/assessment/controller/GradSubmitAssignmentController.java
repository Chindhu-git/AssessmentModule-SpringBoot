package com.example.demo.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.assessment.repository.GradSubmitAssignmentRepository;
import com.example.demo.resource.SubmittedAssignment;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/login/grad/assignment")
public class GradSubmitAssignmentController {
	@Autowired
	GradSubmitAssignmentRepository gradSubmitAssignmentRepository;
	
	@PostMapping(path="/submit")
	public String uploadassignment(@RequestBody SubmittedAssignment submittedAssignment) throws Exception
	{
		return gradSubmitAssignmentRepository.uploadassignment(submittedAssignment.assignment_name,submittedAssignment.email,submittedAssignment.filename, submittedAssignment.uploadfile);
	}
}
