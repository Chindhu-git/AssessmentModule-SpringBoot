package com.example.demo.resource;

public class ProjectViewSubmission {
	public String grademail;
	public String projectlink;
	public int score;
	public ProjectViewSubmission()
	{
		
	}
	ProjectViewSubmission(String grademail, String projectlink, int score)
	{
		this.grademail=grademail;
		this.projectlink=projectlink;
		this.score=score;
	}
	public String getGradEmail()
	{
		return grademail;
	}
	public void setGradEmail(String grademail)
	{
		this.grademail=grademail;
	}
	public String getProjectLink()
	{
		return projectlink;
	}
	public void setProjectLink(String projectlink)
	{
		this.projectlink=projectlink;
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
