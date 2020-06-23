package com.example.demo.resource;

public class EvaluateAssignment {
	public String grademail;
	public String assignment_name;
	public int score;
	public EvaluateAssignment()
	{
		
	}
	public EvaluateAssignment(String assignment_name, String grademail, int score)
	{
		this.grademail=grademail;
		this.assignment_name=assignment_name;
		this.score=score;
	}
	public String getAssignmentName()
	{
		return assignment_name;
	}
	public void setAssignmentName(String assignment_name)
	{
		this.assignment_name=assignment_name;
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
