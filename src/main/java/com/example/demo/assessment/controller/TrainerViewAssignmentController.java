package com.example.demo.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.assessment.repository.TrainerViewAssignmentRepository;
import com.example.demo.resource.ViewSubmission;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/login/trainer/assignment")
public class TrainerViewAssignmentController {
	@Autowired
	TrainerViewAssignmentRepository trainerViewAssignmentRepository;
	
	@GetMapping(path="/view/{assignment_name}")
	public List<ViewSubmission> showFromDB(@PathVariable String assignment_name)
	{
		return trainerViewAssignmentRepository.showFromDB(assignment_name);
	}
}
