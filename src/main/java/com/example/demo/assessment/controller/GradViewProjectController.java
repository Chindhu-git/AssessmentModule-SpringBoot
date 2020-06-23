package com.example.demo.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.assessment.repository.GradViewProjectRepository;
import com.example.demo.resource.ViewProject;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/login/grad/project")
public class GradViewProjectController {
	@Autowired
	GradViewProjectRepository gradViewProjectRepository;
	
	@GetMapping(path="/show")
	public List<ViewProject> showFromDB()
	{
		return gradViewProjectRepository.showFromDB();
	}
	
}
