package com.example.demo.resource;

public class EvaluateProject {
	public String grademail;
	public String project_name;
	public int score;
	public EvaluateProject()
	{
		
	}
	public EvaluateProject(String project_name, String grademail, int score)
	{
		this.grademail=grademail;
		this.project_name=project_name;
		this.score=score;
	}
	public String getProjectName()
	{
		return project_name;
	}
	public void setProjectName(String project_name)
	{
		this.project_name=project_name;
	}
	public String getGradEmail()
	{
		return grademail;
	}
	public void setGradEmail(String grademail)
	{
		this.grademail=grademail;
	}
	public int getScore()
	{
		return score;
	}
	public void setScore(int score)
	{
		this.score=score;
	}
}
