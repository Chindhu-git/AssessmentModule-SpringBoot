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

import com.example.demo.assessment.repository.TrainerCreateQuizRepository;
import com.example.demo.resource.AddQuestions;
import com.example.demo.resource.CreateQuiz;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/login/trainer/quiz")
public class TrainerCreateQuizController {
	@Autowired
	TrainerCreateQuizRepository trainerCreateQuizRepository;
	
	@PostMapping(path="/create")
	public String saveToDB(@RequestBody CreateQuiz createQuiz)
	{
		return trainerCreateQuizRepository.saveToDB(createQuiz.email,createQuiz.title);
	}
	
	@GetMapping(path="/show/{email}")
	public List<CreateQuiz> showFromDB(@PathVariable String email)
	{
		return trainerCreateQuizRepository.showFromDB(email);
	}
	
	@PostMapping(path="/add")
	public String addQue(@RequestBody AddQuestions addQuestions)
	{
		return trainerCreateQuizRepository.addQue(addQuestions.quiz_name,addQuestions.que, addQuestions.opta,addQuestions.optb,addQuestions.optc,addQuestions.optd,addQuestions.ans);
	}
}
