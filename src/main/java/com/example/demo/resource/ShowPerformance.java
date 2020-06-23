package com.example.demo.resource;

public class ShowPerformance {
	public String title;
	public String specification;
	public int score;
	public ShowPerformance()
	{
		
	}
	public ShowPerformance(String title,String specification,int score)
	{
		super();
		this.title=title;
		this.specification=specification;
		this.score=score;
	}
	public int getScore()
	{
		return score;
	}
	public void setScore(int score)
	{
		this.score=score;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title=title;
	}
	public String getSpecification()
	{
		return specification;
	}
	public void setSpecification(String specification)
	{
		this.specification=specification;
	}
}
