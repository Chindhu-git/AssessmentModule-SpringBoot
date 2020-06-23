package com.example.demo.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.assessment.repository.TrainerEvaluateAssignmentRepository;
import com.example.demo.resource.EvaluateAssignment;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/login/trainer/assignment")
public class TrainerEvaluateAssignmentController {
	@Autowired
	TrainerEvaluateAssignmentRepository trainerEvaluateAssignmentRepository;
	
	@PostMapping(path="/evaluate")
	public String evaluateSubmission(@RequestBody EvaluateAssignment evaluateAssignment)
	{
		return trainerEvaluateAssignmentRepository.evaluateSubmission(evaluateAssignment.assignment_name,evaluateAssignment.grademail,evaluateAssignment.score);
	}
}
