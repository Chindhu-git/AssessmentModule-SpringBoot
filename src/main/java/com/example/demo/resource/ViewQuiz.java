package com.example.demo.resource;

public class ViewQuiz {
	public String email;
	public String title;
	public ViewQuiz()
	{
		
	}
	public ViewQuiz(String email,String title)
	{
		super();
		this.email=email;
		this.title=title;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title=title;
	}
}
