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

import com.example.demo.assessment.repository.TrainerCreateAssignmentRepository;
import com.example.demo.resource.CreateAssignment;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/login/trainer/assignment")
public class TrainerCreateAssignmentController {
	
	@Autowired
	TrainerCreateAssignmentRepository trainerCreateAssignmentRepository;			
	
	@GetMapping()
	public String home()
	{
		return "Hey";
	}
	@PostMapping(path="/create")
	public String saveToDB(@RequestBody CreateAssignment createAssignment)
	{
		System.out.println(createAssignment.description);
		String repocheck=trainerCreateAssignmentRepository.saveToDB(createAssignment.email,createAssignment.title,createAssignment.description);
		return repocheck;
	}
	@GetMapping(path="/show/{email}")
	public List<CreateAssignment> showFromDB(@PathVariable String email)
	{
		return trainerCreateAssignmentRepository.showFromDB(email);
	}
}
