package com.example.demo.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.assessment.repository.GradViewQuizRepository;
import com.example.demo.resource.ViewQuiz;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/login/grad/quiz")
public class GradViewQuizController {
	@Autowired
	GradViewQuizRepository gradViewQuizRepository;
	
	@GetMapping(path="/show")
	public List<ViewQuiz> showFromDB()
	{
		return gradViewQuizRepository.showFromDB();
	}
}
