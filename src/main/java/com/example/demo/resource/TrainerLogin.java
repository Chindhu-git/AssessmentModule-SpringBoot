package com.example.demo.resource;

public class TrainerLogin {
	public String email;
	public String password;
	public TrainerLogin(String email,String password)
	{
		this.email=email;
		this.password=password;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public String password()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}
}	
