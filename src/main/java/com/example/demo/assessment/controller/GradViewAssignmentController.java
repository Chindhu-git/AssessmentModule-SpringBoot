package com.example.demo.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.assessment.repository.GradViewAssignmentRepository;
import com.example.demo.resource.ViewAssignment;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/login/grad/assignment")
public class GradViewAssignmentController {
	@Autowired
	GradViewAssignmentRepository gradViewAssignmentRepository;
	
	@GetMapping(path="/show")
	public List<ViewAssignment> showFromDB()
	{
		return gradViewAssignmentRepository.showFromDB();
	}
}
