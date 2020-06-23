package com.example.demo.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.assessment.repository.GradLoginRepository;
import com.example.demo.resource.GradLogin;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/login/grad")
public class GradLoginController {

	@Autowired
	GradLoginRepository gradLoginRepository;			
	
	@GetMapping()
	public String home()
	{
		return "Hey";
	}
	@PostMapping(path="/authenticate")
	public String checkGrad(@RequestBody GradLogin gradLogin)
	{
		System.out.println(gradLogin.email);
		List<String> repocheck=gradLoginRepository.checkGrad(gradLogin.email,gradLogin.password);
		boolean repoCheck=repocheck.isEmpty();
		if(repoCheck==true)
			return "Invalid Login";
		else
			return "Authenticated";
	}
	/*@GetMapping(path="/gradlist")
	public List<String> getAllGrads()
	{
		return gradLoginRepository.getAllGrads();
	}*/
}
